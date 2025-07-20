// basic interface for lists
public interface MyList<E> {
    void add(E el);
    E get(int i);
    E remove(int i);
    int size();
    boolean isEmpty();
    java.util.Iterator<E> iterator();
    void set(int i, E el);
}