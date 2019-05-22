package ru.job4j.list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Node} linked list.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 22.05.2019
 */
public class NodeTest {
    @Test
    public void whenEndLoopThenResultTrue() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node3;
        assertThat(Node.hasCycle(node1), is(true));
    }

    @Test
    public void whenMiddleLoopThenResultTrue() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;
        assertThat(Node.hasCycle(node1), is(true));
    }

    @Test
    public void whenHaveNoLoopThenResultFalse() {
        Node<Integer> node1 = new Node<>(1);
        Node<Integer> node2 = new Node<>(2);
        Node<Integer> node3 = new Node<>(3);
        Node<Integer> node4 = new Node<>(4);
        Node<Integer> node5 = new Node<>(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        assertThat(Node.hasCycle(node1), is(false));
    }

    @Test(expected = NullPointerException.class)
    public void whenAllNodesNullThenResultFalse() {
        Node.hasCycle(null);
    }
}