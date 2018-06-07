package ru.mzainullin.iterators.list;

/**
 * @author Marat Zainullin
 * @since 07.06.2018
 */
public class Node<T> {

    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    boolean hasCycle(Node first) {
        Node turtle = first;
        Node hare = first;

        while (hare != null && hare.next != null) {
            turtle = turtle.next;
            hare = hare.next.next;
            if (turtle.equals(hare)) {
                return true;
            }
        }
        return false;
    }
}