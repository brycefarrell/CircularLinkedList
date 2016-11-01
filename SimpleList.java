/**
 * @author Bryce Farrell
 * 
 * @version Generic SimpleList Interface
 */

public interface SimpleList<T>
{
    public void add(int index, T element);
    public void add(T element);
    public T get(int index);
    public T remove(int index);
    public int size();   
}
