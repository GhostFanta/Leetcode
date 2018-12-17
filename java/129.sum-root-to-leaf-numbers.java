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
    public int sumNumbers(TreeNode root) {
        int res = 0;
        List<List<Integer>> store = new ArrayList<>();
        travel(store, new ArrayList<Integer>(), root);
        for(List<Integer> i : store){
            res += recover(i);
        }
        return res;
    }

    public void travel(List<List<Integer>> store, List<Integer> cur, TreeNode node){
        if(node == null){
            return;
        }

        if(node.left == null && node.right == null){
            cur.add(node.val);
            store.add(new ArrayList<Integer>(cur));
            return;
        }

        cur.add(node.val);
        travel(store, new ArrayList<Integer>(cur), node.left);
        travel(store, new ArrayList<Integer>(cur), node.right);
    }

    public int recover(List<Integer> cur){
        int count = 1;
        int res = 0;
        for(int i = 0 ; i < cur.size() ; i++){
            res += Math.pow(10, cur.size() - count) * cur.get(i);
            count++;
        }
        return res;
    }
}
