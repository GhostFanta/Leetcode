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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> store = new ArrayList<>();
        travel(store, root, 1);
        return store;
    }

    public void travel(List<List<Integer>> store, TreeNode node, int depth){
        if(node == null){
            return;
        }

        if(store.size() < depth){
            List<Integer> mem = new ArrayList<>();
            mem.add(node.val);
            store.add(mem);
        } else {
            List<Integer> mem = store.get(depth - 1);
            mem.add(node.val);
        }

        travel(store, node.left, depth + 1);
        travel(store, node.right, depth + 1);
    }
}
