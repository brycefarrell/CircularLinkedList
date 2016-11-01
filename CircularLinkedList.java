
/**
  * Doubly-linked CircularLinkedList Class
  *
  * @author Bryce Farrell
  *
  * @version Fall 2016
  */


import java.util.*;


public class CircularLinkedList<T> implements SimpleList<T>
{
    private Node head;
    private int size;


    public CircularLinkedList()
    {
        size = 0;
        head = null;
    }

    public void add(T element)
    {
        Node newNode = new Node(element);
        if (size == 0)
        {
            head = newNode;
            head.next = head;
            head.previous = head;
        }
        else
        {
            head.previous.next = newNode;
            newNode.previous = head.previous;
            head.previous = newNode;
            newNode.next = head;
        }   
        

        size++;
        

    }

    //?
    public void shiftHeadRight()
    {
        head = head.next;
    }

    public void add(int index, T element)
    {
        if (index > size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        Node newNode = new Node(element);
        if (size == 0)
        {
            this.add(element);   
        }
        else
        {
            Node before = getNode(index - 1);
            Node after = before.next;
            newNode.previous = before;
            after.previous = newNode;
            newNode.next = after;
            before.next = newNode;
        }
        size++;   
    }
    

 

    public T get(int index)
    {
        if (index == size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        Node p = getNode(index);
        return p.element;
    }

    


    public T remove(int index)
    {
        T rv;
        
        if (index >= size || index < 0)
        {
            throw new IndexOutOfBoundsException();
        }
        
        if (index == 0)
        {
            rv = head.element;

            Node temp = head;
            head = head.next;
            head.previous = temp.previous;
            temp.previous.next = head;
        }
        else if (index == size - 1)
        {
            rv = head.previous.element;
            head.previous = head.previous.previous;
            head.previous.next = head;
        }
        else
        {
            Node node = getNode(index);
            Node n = getNode(index + 1);
            Node p = getNode(index - 1);
            n.previous = p;
            p.next = n;
            rv = node.element;
        }        
        size--;
        return rv;
    }


    public int size()
    {
        return size;
    }

    
    private Node getNode(int i)
    {
        if (i == 0)
        {
            return head;
        }
        else if (i == size - 1)
        {
            return head.previous;
        }
        else if (i < (size/2))
        {
            
            Node p = head;
            int pos = 0;
            while (pos != i)
            {
                p = p.next;
                pos++;
            }
            return p;
        }
        else
        {
            Node p = head.previous;
            int pos = size - 1;
            while (pos != i)
            {
                p = p.previous;
                pos--;
            }
            return p;
        }
    }

    //private classes
    private class Node
    {
        public T element;
        public Node next;
        public Node previous;
        
        public Node(T element)
        {
            this.element = element;
            this.next = null;
            this.previous = null;
        }
    }
    
}
