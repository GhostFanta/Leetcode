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
    public List<Integer> rightSideView(TreeNode root) {
        List<Stack<Integer>> store = new ArrayList<>();
        helper(root, store, 1);
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ; i < store.size()  ; i++){
            res.add(store.get(i).peek());
        }
        return res;
    }

    public void helper(TreeNode node, List<Stack<Integer>> store, int depth){
        if(node == null){
            return;
        }
        if(store.size() < depth){
            store.add(new Stack<Integer>());
        }

        Stack<Integer> curr = store.get(depth - 1);
        curr.push(node.val);
        helper(node.left, store, depth + 1);
        helper(node.right, store, depth + 1);
   }
}
