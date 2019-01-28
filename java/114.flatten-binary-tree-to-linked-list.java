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
    private TreeNode last;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }

        if(last != null){
            last.left = null;
            last.right = root;
        }

        last = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}
