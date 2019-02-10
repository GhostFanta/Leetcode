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
    public List<TreeNode> depnodes;
    public int maxdep;
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        this.depnodes = new ArrayList<>();
        this.maxdep = 0;
        Map<TreeNode, TreeNode> store = new HashMap<>();
        List<Stack<TreeNode>> track = new ArrayList<>();
        this.helper(store, root, null, 0);

        TreeNode prev = depnodes.get(0);
        boolean flag = false;
        while(!flag){
            boolean con = false;
            for(TreeNode node : depnodes){
                if(node != prev){
                    for(int i = 0 ; i < depnodes.size() ; i++){
                        TreeNode  tempnode = depnodes.get(i);
                        depnodes.set(i,store.get(tempnode));
                    }
                    prev = depnodes.get(0);
                    con = true;
                    break;
                } else {
                    prev = node;
                }
            }
            if(!con){
                flag = true;
            }
        }
        return !flag ? null : prev;
    }

    public void helper(Map<TreeNode, TreeNode> store, TreeNode node, TreeNode parent, int depth){
        if(node == null){
            return;
        }

        store.put(node, parent);
        if(this.maxdep < depth){
            this.maxdep = depth;
            this.depnodes.clear();
            this.depnodes.add(node);
        } else if(this.maxdep == depth){
            this.depnodes.add(node);
        }

        this.helper(store, node.left, node, depth + 1);
        this.helper(store, node.right, node, depth + 1);
    }
}
