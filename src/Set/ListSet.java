package Set;

import java.util.LinkedList;

public class ListSet<E extends Comparable<E>> implements Set<E> {

    private LinkedList set;

    public ListSet() {
        set = new LinkedList();
    }

    @Override
    public void add(E e) {
        if (!set.contains(e)) {
            set.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
        if (set.contains(e)) {
            set.remove(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return set.contains(e);
    }

    @Override
    public int getSize() {
        return set.size();
    }

    @Override
    public boolean isEmpty() {
        return set.isEmpty();
    }
}
