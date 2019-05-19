package ru.job4j.binarytree;

/**
 * The {@code BinaryTree} class provides searching operation in the binary tree.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.05.2019
 */
public class BinaryTree {
    /**
     * Searches the Least Common Node of two binary tree nodes.
     *
     * @param left  The Value of a left node (1 <= node1 <= 10^9).
     * @param right The Value of a right node (1 <= node1 <= 10^9).
     * @return The value of the Least Common Node.
     */
    public int findParent(int left, int right) {
        int hLeft = depth(left);
        int hRight = depth(right);
        while (hLeft != hRight) {
            if (hLeft > hRight) {
                left = parent(left);
                hLeft--;
            } else {
                right = parent(right);
                hRight--;
            }
        }
        while (left != right) {
            left = parent(left);
            right = parent(right);
        }
        return left;
    }

    /**
     * Calculates the depth level of the binary tree node.
     *
     * @param nodeValue The value of a binary tree node.
     * @return The depth level of the input node.
     */
    private int depth(int nodeValue) {
        return (int) (Math.log10(nodeValue) / Math.log10(2));
    }

    /**
     * Calculates the parent node value of the binary tree node.
     *
     * @param nodeValue The value of a binary tree node.
     * @return The parent value of the binary tree node.
     */
    private int parent(int nodeValue) {
        return nodeValue % 2 == 0 ? nodeValue / 2 : (nodeValue - 1) / 2;
    }
}
