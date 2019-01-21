class Solution {
    public int[] productExceptSelf(int[] nums) {
        int temp = 1;
        int[] mem = new int[nums.length];

        for(int i = nums.length - 1 ; i >= 0; i--){
            temp *= nums[i];
            mem[i] = temp;
        }

        temp = 1;
        int[] res = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            temp = i == 0 ? 1 : nums[i - 1] * temp;
            int right = i == nums.length - 1 ? 1 : mem[i + 1];
            res[i] = temp * right;
        }

        return res;
    }
}
