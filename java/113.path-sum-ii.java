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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> store = new ArrayList<>();
        helper(root, store, new ArrayList<Integer>(), 0, sum);
        return store;
    }

    public void helper(TreeNode node, List<List<Integer>> store, List<Integer> cur, int sum, int target){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            sum += node.val;
            if(sum == target){
                cur.add(node.val);
                store.add(new ArrayList<Integer>(cur));
            }
            return;
        }

        cur.add(node.val);
        sum += node.val;
        helper(node.left, store, new ArrayList<Integer>(cur), sum, target);
        helper(node.right, store, new ArrayList<Integer>(cur), sum, target);
    }
}
