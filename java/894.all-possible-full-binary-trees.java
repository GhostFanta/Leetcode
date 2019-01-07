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

    Map<Integer, List<TreeNode>> store = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {

        if(!this.store.containsKey(N)){
            List<TreeNode> cur = new ArrayList<>();
            if(N == 1){
                cur.add(new TreeNode(0));
            } else if(N % 2 == 1){
                for(int i = 0 ; i < N ; i++){
                    for(TreeNode n : allPossibleFBT(i)){
                        int right = N - 1 - i;
                        for(TreeNode k : allPossibleFBT(right)){
                            TreeNode root = new TreeNode(0);
                            root.left = n;
                            root.right = k;
                            cur.add(root);
                        }
                    }
                }
            }
            this.store.put(N, cur);
        }

        return this.store.get(N);
    }
}
