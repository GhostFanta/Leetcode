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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> store = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while(root != null || !store.isEmpty()){
            while(root != null){
                store.push(root);
                root = root.left;
            }

            TreeNode node = store.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }
}
