// Array-based list
public class MyArrayList<E> implements MyList<E> {
    private Object[] a = new Object[5]; // Storage array
    private int s = 0; // Size

    public void add(E el) {
        if (s == a.length) { // Resize
            Object[] b = new Object[s * 2];
            for(int i = 0; i < s; i++) b[i] = a[i];
            a = b;
        }
        a[s] = el;
        s++;
    }

    public E get(int i) {
        if (i >= s || i < 0) return null;
        return (E) a[i];
    }

    public void set(int i, E el) {
        if (i < s && i >= 0) a[i] = el;
    }

    public E remove(int i) {
        if (i >= s || i < 0) return null;
        E old = (E) a[i];
        for (int j = i; j < s - 1; j++) a[j] = a[j + 1];
        s--;
        return old;
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
        private int p = 0;
        public boolean hasNext() { return p < s; }
        public E next() { return (E) a[p++]; }
    }
}