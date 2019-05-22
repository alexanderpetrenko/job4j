package ru.job4j.list;

/**
 * {@code Node} class provides saving data.
 *
 * @param <T> A reference type of array elements.
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    /**
     * Checks if linked list has loops.
     *
     * @param first The first element of linked list.
     * @return {@code true} if linked list is cycled; otherwise {@code false}.
     */
    public static boolean hasCycle(Node first) {
        if (first == null) {
            throw new NullPointerException("First Node is NULL");
        }
        Node slow = first;
        Node fast = first;
        do {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
            if (slow == null || fast == null) {
                break;
            }
        } while (slow != fast);
        return slow == fast;
    }
}
