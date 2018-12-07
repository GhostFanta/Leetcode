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
    public int rangeSumBST(TreeNode root, int L, int R) {
        return this.helper(0, root, L, R);
    }

    public int helper(int sum, TreeNode root, int L, int R){
        if(root == null){
            return 0;
        }

        int carry = root.val < L ? 0 : root.val > R ? 0 : root.val;

        return sum + carry + helper(0, root.left, L, R) + helper(0, root.right, L, R);
    }
}
