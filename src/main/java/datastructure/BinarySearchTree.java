package datastructure;

/**
 * Binary Search Tree implementation
 */
public class BinarySearchTree<Key extends Comparable<Key>, Value> {

  private class Node {

    private Key key;
    private Value value;
    private Node left, right;

    Node(Key key, Value value) {
      this.key = key;
      this.value = value;
    }
  }

  private Node root;

  public void put(Key key, Value value) {
    this.root = put(root, key, value);
  }

  public Node put(Node node, Key key, Value value) {
    if(node == null) {
      return new Node(key, value);
    }

    int compare = node.key.compareTo(key);

    if(compare == 0) node.value = value;
    else if(compare < 0) node.right = put(node.right, key, value);
    else if(compare > 0) node.left = put(node.left, key, value);

    return node;
  }


  public Value get(Key key) {
    return get(root, key);
  }

  private Value get(Node node, Key key) {
    if (node == null) {
      return null;
    }

    int compare = node.key.compareTo(key);
    if (compare == 0) {
      return node.value;
    } else if (compare < 0) {
      return get(node.right, key);
    } else {
      return get(node.left, key);
    }
  }

  public Key getMinKey() {
    Node minKeyNode = getMinKeyNode(root);
    return minKeyNode == null ? null : minKeyNode.key;
  }

  private Node getMinKeyNode(Node node) {
    if (node == null) {
      return null;
    }
    Node min = null;
    while (min.left != null) {
      min = min.left;
    }
    return min;
  }

  public Key getMaxKey() {
    Node maxKeyNode = getMaxKeyNode(root);
    return maxKeyNode == null ? null : maxKeyNode.key;
  }

  private Node getMaxKeyNode(Node node) {
    if (node == null) {
      return null;
    }

    Node max = node;

    while (max.right != null) {
      node = node.right;
    }

    return node;
  }

  public void delete(Key key) {
    this.root = delete(root, key);
  }

  // delete node with key, return current root
  public Node delete(Node node, Key key) {
    if(node == null) { return node; }

    int compare = node.key.compareTo(key);

    if(compare < 0) node.right = delete(node.right, key);
    else if(compare > 0) node.left = delete(node.left, key);
    else {

      /*
      * 1. if left is null, new root is right
      * 2. if right is null, new root is left
      * 3. if left and right are not null, new root is smallest number in right subtree
      * */

      if(node.right == null) return node.left;
      if(node.left == null) return node.right;

      Node storeNode = node;
      node = getMinKeyNode(node.right);
      node.left = storeNode.left;
      node.right = deleteMinKey(node.right);
    }

    return node;
  }

  // delete the smallest Key in tree
  private Node deleteMinKey(Node node) {
    if(node == null) return null;
    if(node.left == null) return node.right;
    node.left = deleteMinKey(node.left);
    return node;
  }

  private void printInOrder() {
    printInOrder(root);
  }
  // in order
  private void printInOrder(Node node) {
    if (node == null) {
      return;
    } else {
      printInOrder(node.left);
      System.out.println("node key: " + node.key + "node value:" + node.value);
      printInOrder(node.right);
    }
  }

  public static void main(String[] args) {
    BinarySearchTree<Integer, Integer> bst = new BinarySearchTree();


        bst.put(2, 2);
        bst.put(1,1);
        bst.put(5,5 );
        bst.put(3, 3);
        bst.put(4, 4);

//        bst.deleteMin();

       bst.delete(3);
       bst.delete(6);
     bst.printInOrder();

  }
}
