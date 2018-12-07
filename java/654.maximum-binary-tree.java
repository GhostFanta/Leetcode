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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return this.helper(nums);
    }

    public TreeNode helper(int[] nums){
        if(nums == null || nums.length == 0){
            return null;
        }

        int val = nums[0];
        int index = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > val){
                val = nums[i];
                index = i;
            }
        }

        TreeNode node = new TreeNode(val);
        node.left = this.helper(Arrays.copyOfRange(nums, 0, index));
        node.right = this.helper(Arrays.copyOfRange(nums, index + 1, nums.length));
        return node;
    }
}
