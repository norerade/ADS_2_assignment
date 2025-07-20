// Min heap using array list
public class MyMinHeap<E extends Comparable<E>> {
    private MyArrayList<E> h = new MyArrayList<>();

    public void insert(E e) {
        h.add(e);
        int i = h.size() - 1;
        while (i > 0) {
            int p = (i - 1) / 2;
            if (h.get(i).compareTo(h.get(p)) < 0) {
                E temp = h.get(i);
                h.set(i, h.get(p));
                h.set(p, temp);
                i = p;
            } else break;
        }
    }

    public E extractMin() {
        E min = h.get(0);
        h.set(0, h.get(h.size() - 1));
        h.remove(h.size() - 1);
        int i = 0;
        while (true) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            int sm = i;
            if (l < h.size() && h.get(l).compareTo(h.get(sm)) < 0) sm = l;
            if (r < h.size() && h.get(r).compareTo(h.get(sm)) < 0) sm = r;
            if (sm != i) {
                E temp = h.get(i);
                h.set(i, h.get(sm));
                h.set(sm, temp);
                i = sm;
            } else break;
        }
        return min;
    }

    public boolean isEmpty() {
        return h.isEmpty();
    }
}