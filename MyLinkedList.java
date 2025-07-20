// Linked list
public class MyLinkedList<E> implements MyList<E> {
    private class N { // node
        E v;
        N n;
        N p;
        N(E vv) { v = vv; }
    }

    private N h; // head
    private N t; // tail
    private int s = 0;

    public void add(E el) {
        N nn = new N(el);
        if (t == null) {
            h = t = nn;
        } else {
            t.n = nn;
            nn.p = t;
            t = nn;
        }
        s++;
    }

    public E get(int i) {
        if (i < 0 || i >= s) return null;
        N c = h;
        for (int j = 0; j < i; j++) c = c.n;
        return c.v;
    }

    public void set(int i, E el) {
        if (i < 0 || i >= s) return;
        N c = h;
        for (int j = 0; j < i; j++) c = c.n;
        c.v = el;
    }

    public E remove(int i) {
        if (i < 0 || i >= s) return null;
        N nn = h;
        for (int j = 0; j < i; j++) nn = nn.n;
        if (nn.p == null) h = nn.n;
        else nn.p.n = nn.n;
        if (nn.n == null) t = nn.p;
        else nn.n.p = nn.p;
        s--;
        return nn.v;
    }

    public int size() {
        return s;
    }

    public boolean isEmpty() {
        return s == 0;
    }

    public java.util.Iterator<E> iterator() {
        return new It();
    }

    private class It implements java.util.Iterator<E> {
        N c = h;
        public boolean hasNext() { return c != null; }
        public E next() { E vv = c.v; c = c.n; return vv; }
    }
}