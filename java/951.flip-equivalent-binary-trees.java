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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(root1 == null || root2 == null){
            if(root1 == root2){
                return true;
            } else {
                return false;
            }
        }

        boolean current = root1.val == root2.val;
        return (current && flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
            (current && flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
    }
}
