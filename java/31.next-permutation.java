class Solution {
    public void nextPermutation(int[] nums) {
        int last = nums.length - 1;

        for(int i = nums.length - 2; i >= 0 ; --i){
            if(nums[i] < nums[last]){
                int just = Integer.MAX_VALUE;
                int index = i;
                for(int j = i ; j < nums.length ; j++){
                    if(nums[j] <= just && nums[j] > nums[i]){
                        just = nums[j];
                        index = j;
                    }
                }
                nums[index] = nums[i];
                nums[i] = just;
                Arrays.sort(nums, i + 1, nums.length);
                return;
            }
            last = i;
        }
        Arrays.sort(nums);
    }
}
