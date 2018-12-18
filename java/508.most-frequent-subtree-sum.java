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
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> store = new HashMap<>();
        int flag = 0;
        List<Integer> temp = new ArrayList<>();
        this.travel(store, root);
        for(Integer i : store.keySet()){
            int val = store.get(i);
            if(val > flag){
                flag = val;
                temp.clear();
                temp.add(i);
            } else if(val == flag) {
                temp.add(i);
            }
        }
        int[] res = new int[temp.size()];
        for(int i = 0 ; i < temp.size() ; i++){
            res[i] = temp.get(i);
        }
        return res;
    }

    public void travel(Map<Integer, Integer> store, TreeNode node){
        if(node == null){
            return;
        }
        int sumval = sum(node);
        store.put(sumval, store.getOrDefault(sumval, 0) + 1);
        travel(store, node.left);
        travel(store, node.right);
    }

    public int sum(TreeNode node){
        if(node == null){
            return 0;
        }
        if(node.left == null && node.right == null){
            return node.val;
        }
        return node.val + sum(node.left) + sum(node.right);
    }
}
