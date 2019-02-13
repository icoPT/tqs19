/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqsua.lab1stack;

/**
 *
 * @author ico
 */
public interface ITqsStack<T> {
    /**
     * Adds the given item to the top of the stack.
     */
    void push(T item);

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    T pop();

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the stack is empty.
     */
    T peek();

    /**
     * Returns the number of items currently in the stack.
     */
    int size();

    /**
     * Returns whether the stack is empty or not.
     */
    boolean isEmpty();    
    
}
