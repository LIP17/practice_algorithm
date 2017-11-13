package datastructure;

import com.sun.org.apache.regexp.internal.RE;
import sun.security.util.ByteArrayLexOrder;

import java.util.Set;
import java.util.TreeSet;

/**
 * From: Princeton - Algorithm book
 *
 * Red-Black tree is a binary tree with red/black link,
 * it met the definition :
 * 1. Red links lean left.
 * 2. No node has two red links connected to it.
 * 3. The tree has perfect black balance: every path from the root to a
 * null link has the same number of black links.
 *
 */
public class RedBlackTree <Key extends Comparable<Key>, Value>{
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        boolean color; // the color of link to its parent
        Node(Key key, Value val, Boolean color) {
            this.key = key; this.value = val; this.color = color;
        }
    }

    private Node root;

    /**
     * Base case:
     * 1. Insert value in a single 2 node.
     * 2. Insert value in a 2 node at bottom.
     * 3. Insert value in a single 3 node.
     * 4. Insert value in a 3 node at bottom.
     * 5. Passing a red link up the tree.
     * */
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node h, Key key, Value val) {
        /**
         * 1. If the right child is red and left is black, rotate left.
         * 2. If both left child is red and its left child is red, rotate right.
         * 3. If both children are red, flip color
         * */
        if(h == null) return new Node(key, val, RED);

        int cmp = key.compareTo(h.key);

        if(cmp < 0) h.left = put(h.left, key, val);
        else if(cmp > 0) h.right = put(h.right, key, val);
        else h.value = val;

        if(isRed(h.right) && !isRed(h.left)) h = rotateLeft(h);
        if(isRed(h.left) && isRed(h.left.left)) rotateRight(h);
        if(isRed(h.left) && isRed(h.right)) flipColors(h);

        return h;
    }


    /**
     * In the process, if a red link appear in right,
     * we want to rotate it back to left. // page 434
     * */
    private Node rotateLeft(Node h) {
        Node x = h.right; // x and h connected with red link now
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    /**
     * In the process, if a red link appear in left,
     * we want ot rotate it back to right. // page 434
     * */
    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private boolean isRed(Node n) {
        if(n == null) return BLACK;
        return n.color;
    }

    private void printTree(Node node) {
        if (node == null) return;
        else {
            printTree(node.left);
            System.out.print("node key: " + node.key + "node value:" + node.value + ";;;");
            printTree(node.right);
        }
    }

    private void printFullTree() {
        printTree(root);
        System.out.println();
    }

    // TODO: implemente delete method
    private void delete(Node n) {

    }

    public static void main(String[] args) {
        RedBlackTree rbTree = new RedBlackTree<Integer, Integer>();

        rbTree.put(1, 1);

        rbTree.printFullTree();

        rbTree.put(2,2);

        rbTree.printFullTree();

        rbTree.put(3, 3);

        rbTree.printFullTree();

    }
}
