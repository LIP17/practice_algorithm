package datastructure;

/**
 * Binary Search Tree implementation
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int sizeOfSubtree;

        Node(Key key, Value value, int sizeOfSubtree) {
            this.key = key;
            this.value = value;
            this.sizeOfSubtree = sizeOfSubtree;
        }
    }

    private Node root;

    public int size() { return size(root); }

    private int size(Node node) {
        if (node == null) return 0;
        else return size(node.left) + size(node.right) + 1;
    }

    public Value get(Key key) { return get(root, key); }

    private Value get(Node node, Key key) {
        if(node == null || key == null) return null;

        Node curr = node;
        while (curr != null) {
            int cmp = key.compareTo(node.key);
            if (cmp == 0) return node.value;
            else if(cmp < 0) curr = curr.left;
            else curr = curr.right;
        }
        return null;
    }


    public void put(Key key, Value val) { this.root = put(this.root, key, val); }

    public Node put(Node node, Key key, Value value) {
        if(node == null) return new Node(key, value, 1);
        int cmp = key.compareTo(node.key);

        if(cmp == 0) node.value = value;
        else if(cmp < 0) node.left = put(node.left, key, value);
        else node.right = put(node.right, key, value);

        node.sizeOfSubtree = size(node.left) + size(node.right) + 1;
        return node;
    }

    /**
     * @param key
     * get the floor of key
     * */
    public Key floor(Key key) {
        return null;
    }

    private Node floor(Node node, Key key) {
        if (node == null) return null;

        int cmp = key.compareTo(node.key);

        if(cmp == 0) return node;
        else if(cmp < 0) return floor(node.left, key);
        else {
            Node t = floor(node.right, key);
            return (t == null) ? node : t;
        }
    }

    // if you want to get the minimum out of tree
    public void deleteMin() { root = deleteMin(root); }


    private Node deleteMin(Node node) {
        if(node.left == null) return node.right;
        node.left = deleteMin(node.left);
        node.sizeOfSubtree = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key) { root = delete(root, key); }

    private Node min(Node node) {
        if(node == null) return null;

        Node pointer = node;
        while (node.left != null) pointer = pointer.left;

        return pointer;
    }


    /**
     * delete the key in node, and return the replacement node.
     * */
    private Node delete(Node node, Key key) {
        if(node == null) return null;

        int cmp = key.compareTo(node.key);

        if(cmp > 0) node.right = delete(node.right, key);
        else if(cmp < 0) node.left = delete(node.left, key);
        else {
            if(node.right == null) return node.left;
            if(node.left == null) return node.right;
            Node storeNode = node;

            /**
             * if you delete current node, and both its left and right subtree exist,
             * then the replacement of this will be the minimum node in its right subtree.
             * */
            node = min(node.right);
            node.left = storeNode.left;
            node.right = deleteMin(storeNode.right);
        }

        node.sizeOfSubtree = size(node.left) + size(node.right) + 1;

        return node;
    }



    public void printTree() { printTree(this.root); }

    // in order
    private void printTree(Node node) {
        if (node == null) return;
        else {
            printTree(node.left);
            System.out.println("node key: " + node.key + "node value:" + node.value);
            printTree(node.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree();
        bst.put(2, 2);
        bst.put(1,1);
        bst.put(5,5 );
        bst.put(3, 3);
        bst.put(4, 4);

//        bst.printTree();

//        bst.deleteMin();



        bst.delete(3);
        bst.printTree();



    }
}
