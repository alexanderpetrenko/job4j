package ru.job4j.binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The {@code BinaryTree} class provides searching operation in the binary tree.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 16.05.2019
 */
public class BinaryTree {
    /**
     * List of Nodes from the First Node to the Root of the Binary Tree.
     */
    private List<Node> branch1 = new ArrayList<>();
    /**
     * List of Nodes from the Second Node to the Root of the Binary Tree.
     */
    private List<Node> branch2 = new ArrayList<>();

    /**
     * Constructor initialize two branches from each node to the Root
     * of the Binary tree.
     *
     * @param node1 Value of the First Node (1< = node1 <= 10^9).
     * @param node2 Value of the Second Node (1< = node2 <= 10^9).
     */
    public BinaryTree(int node1, int node2) {
        setBranch(this.branch1, new Node(node1));
        setBranch(this.branch2, new Node(node2));
    }

    /**
     * The method provides parent node search and adds it to the list.
     *
     * @param branch List of Nodes from input node to the Root.
     * @param node   Input Node.
     */
    private void setBranch(List<Node> branch, Node node) {
        branch.add(node);
        if (node.getValue() >= 1) {
            Node parentNode;
            if (node.getValue() % 2 == 0) {
                parentNode = new Node(node.getValue() / 2);
            } else {
                parentNode = new Node((node.getValue() - 1) / 2);
            }
            this.setBranch(branch, parentNode);
        }
    }

    /**
     * The method searches the Least Common Node of two branches.
     *
     * @return Value of the Least Common Node.
     */
    public int leastCommonNode() {
        List<Node> common;
        if (branch1.size() > branch2.size()) {
            common = new ArrayList<>(branch2);
            common.retainAll(branch1);
        } else {
            common = new ArrayList<>(branch2);
            common.retainAll(branch1);
        }
        return common.stream().max(Comparator.comparing(Node::getValue))
                .orElse(new Node(0)).getValue();
    }
}
