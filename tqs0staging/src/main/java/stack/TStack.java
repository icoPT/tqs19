package stack;

import java.util.LinkedList;

public class TStack <T> {
    private LinkedList<T> list = new LinkedList<>();


    public void push(T item) {
        list.addFirst(item);
    }

    public T pop() {
        return list.removeFirst();
    }

    public T peek() {
        return list.getFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
