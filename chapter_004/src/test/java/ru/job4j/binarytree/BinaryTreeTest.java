package ru.job4j.binarytree;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code BinaryTree} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.05.2019
 */
public class BinaryTreeTest {
    @Test
    public void whenNodes9and5ThenCommon2() {
        BinaryTree tree = new BinaryTree(9, 5);
        int expected = 2;
        assertThat(tree.leastCommonNode(), is(expected));
    }

    @Test
    public void whenNodes11and15ThenCommon1() {
        BinaryTree tree = new BinaryTree(11, 15);
        int expected = 1;
        assertThat(tree.leastCommonNode(), is(expected));
    }

    @Test
    public void whenNodes13and15ThenCommon3() {
        BinaryTree tree = new BinaryTree(13, 15);
        int expected = 3;
        assertThat(tree.leastCommonNode(), is(expected));
    }

    @Test
    public void whenNodes13andMinus5ThenCommon0() {
        BinaryTree tree = new BinaryTree(13, -5);
        int expected = 0;
        assertThat(tree.leastCommonNode(), is(expected));
    }
}
