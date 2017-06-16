/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    
    private Stack<TreeNode> nodeStore;

    public BSTIterator(TreeNode root) {
        nodeStore = new Stack();
        
        // save all left hand node first to keep o(1) search time
        // you only saved all left side node, so it guarantee o(h) memory 
        TreeNode currentNode = root;
        while(currentNode != null) {
            nodeStore.push(currentNode);
            currentNode = currentNode.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !nodeStore.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        
        TreeNode minimumNode = nodeStore.pop();
        
        if(minimumNode.right != null) {
            TreeNode currentNode = minimumNode.right;
            while(currentNode != null) {
                nodeStore.push(currentNode);
                currentNode = currentNode.left;
            }
        }
        return minimumNode.val;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */