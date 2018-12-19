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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }

        return helper(root, null, null);
    }

    public boolean helper(TreeNode node, Integer lower, Integer upper){

        if((upper != null) && (node.val >= upper)){
            return false;
        }

        if((lower != null) && (node.val <= lower)){
            return false;
        }

        boolean left = node.left != null ? helper(node.left, lower, node.val) : true; 
        if(left){
            boolean right = node.right != null ? helper(node.right, node.val, upper) : true; 
            return right;
        } else {
            return false;
        }
    }
}
