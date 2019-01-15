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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Stack<TreeNode> store = new Stack<>();
        
        TreeNode node = root;
        while(node != null || !store.isEmpty()){
            res.add(node.val);
            store.push(node);
            if(node.left != null){
                node = node.left;
            } else {
                if(!store.isEmpty()){
                    node = store.pop();
                    while(!store.isEmpty() && node.right == null){
                        node = store.pop();
                    }
                    node = node.right;
                } else {
                    break;
                }
            }
        }
        return res;
    }
}
