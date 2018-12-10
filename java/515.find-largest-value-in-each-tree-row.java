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

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> store = new ArrayList<>();
        this.travel(root, 0, store);
        return store;
    }

    public void travel(TreeNode node, int depth, List<Integer> store){

        if(node == null){
            return;
        }

        if(depth >= store.size()){
            store.add(node.val);
        } else {
            if(store.get(depth) < node.val){
                store.set(depth, node.val);
            }
        }

        travel(node.left, depth + 1, store);
        travel(node.right, depth + 1, store);
    }
}
