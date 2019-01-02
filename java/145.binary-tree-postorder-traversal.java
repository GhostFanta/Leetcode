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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        LinkedList<TreeNode> store = new LinkedList <>();

        if(root == null){
            return res;
        }

        store.add(root);
        while(!store.isEmpty()){
            TreeNode node = store.pollLast();
            res.addFirst(node.val);
            if(node.left != null){
                store.add(node.left);
            }
            if(node.right!= null){
                store.add(node.right);
            }
        }
        return res;
    }
}
