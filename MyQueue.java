// Queue using linked list
public class MyQueue<E> {
    private MyLinkedList<E> l = new MyLinkedList<>();

    public void enqueue(E e) {
        l.add(e);
    }

    public E dequeue() {
        return l.remove(0);
    }

    public boolean isEmpty() {
        return l.isEmpty();
    }
}