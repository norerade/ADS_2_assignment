// Stack using linked list
public class MyStack<E> {
    private MyLinkedList<E> l = new MyLinkedList<>();

    public void push(E e) {
        l.add(e);
    }

    public E pop() {
        return l.remove(l.size() - 1);
    }

    public boolean isEmpty() {
        return l.isEmpty();
    }
}