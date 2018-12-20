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
    private boolean flag;
    public boolean isCompleteTree(TreeNode root) {
        flag = true;
        List<List<TreeNode>> store = new ArrayList<>();
        travel(root, store, 1);
        for(int i = 0 ; i < store.size() - 2 ; i++){
            if(store.get(i).get(store.get(i).size() - 1) == null){
                this.flag = false;
            }
        }
        return this.flag;
    }

    public void travel(TreeNode node, List<List<TreeNode>> store, int depth){
        if(depth > store.size()){
            store.add(new ArrayList<TreeNode>());
        }

        List<TreeNode> cur = store.get(depth - 1);
        if(cur.size() > 0 && cur.get(cur.size() - 1) == null && node != null){
            this.flag = false;
        }
        cur.add(node);
        if(node == null){
            return;
        } 
        travel(node.left, store, depth + 1);
        travel(node.right, store, depth + 1);
    }
}
