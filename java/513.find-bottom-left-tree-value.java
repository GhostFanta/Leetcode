/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    private int maxdepth;
    private int val;

    public int findBottomLeftValue(TreeNode root) {
        this.val = root.val;
        this.maxdepth = 0;
        this.helper(root, 0);
        return this.val;
    }
    
    public void helper(TreeNode node, int depth){
        if(node == null){
            return;
        }

        if(node.left == null && node.right ==  null){
            if(depth > this.maxdepth){
                this.val = node.val;
                this.maxdepth = depth;
            } 
        }

        this.helper(node.left, depth + 1);
        this.helper(node.right, depth + 1);

    }

}
