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

    private Stack<TreeNode> store;

    public BSTIterator(TreeNode root) {
        TreeNode node = root;
        store = new Stack<>();
        while(node != null){
            store.push(node);
            node = node.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !this.store.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = this.store.peek();
        this.store.pop();
        int res = node.val; 
        TreeNode newroot = node.right;
        while(newroot != null){
            store.push(newroot);
            newroot = newroot.left;
        }
        return res;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
