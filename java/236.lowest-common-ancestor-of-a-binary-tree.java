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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        helper(parent, root, null);

        Set<TreeNode> pathp = new HashSet<TreeNode>();

        TreeNode pp = p;
        while(pp != null){
            pathp.add(pp);
            pp = parent.get(pp);
        }
        TreeNode pq = q;

        while(!pathp.contains(pq)){
            pq = parent.get(pq);
        }

        return pq;
    }

    public void helper(Map<TreeNode,TreeNode> store, TreeNode node, TreeNode parent){
        if(node == null){
            return;
        }

        store.put(node, parent);
        helper(store, node.left, node);
        helper(store, node.right, node);
    }
}
