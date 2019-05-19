package ru.job4j.binarytree;

import org.junit.Before;
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
    private BinaryTree tree;

    @Before
    public void setUp() {
        tree = new BinaryTree();
    }

    @Test
    public void whenNodes9and5ThenCommon2() {
        assertThat(tree.findParent(9, 5), is(2));
    }

    @Test
    public void whenNodes11and15ThenCommon1() {
        assertThat(tree.findParent(11, 15), is(1));
    }

    @Test
    public void whenNodes13and15ThenCommon3() {
        assertThat(tree.findParent(13, 15), is(3));
    }
}
