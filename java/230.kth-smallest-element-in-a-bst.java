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
    private int res;
    public int kthSmallest(TreeNode root, int k) {
        helper(root, new Stack<TreeNode>(), 0, k);
        return this.res;
    }

    public void helper(TreeNode node, Stack<TreeNode> store, int rank, int k){
        if(node != null){
            store.push(node);
            helper(node.left, store, rank, k);
        } else {
            if(store.isEmpty()){
                return ;
            }
            node = store.pop();
            rank += 1;
            if(rank == k){
                this.res = node.val;
                return ;
            }
            helper(node.right, store, rank, k);
        }
    }
}
