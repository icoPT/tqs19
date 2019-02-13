package tqsua.lab1stack;

import java.util.LinkedList;

/**
 *
 * @author ico
 */
public class TqsSimpleStack<T> implements ITqsStack<T> {

    private LinkedList<T> list = new LinkedList<>();
    
    @Override
    public void push(T item) {
        list.addFirst(item);
    }

    @Override
    public T pop() {
        return list.removeFirst();
    }

    @Override
    public T peek() {
        return list.getFirst();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
}
