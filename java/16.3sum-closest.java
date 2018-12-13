class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int gap = Integer.MAX_VALUE;
        int res = 0;

        for(int head = 0 ; head < nums.length - 2 ;){
            int left = head + 1;
            int right = nums.length - 1;
 
            while(left < right){
                if (Math.abs(nums[head] + nums[left] + nums[right] - target) < gap){
                    res = nums[head] + nums[left] + nums[right];
                    gap = Math.abs(nums[head] + nums[left] + nums[right] - target);
                }
                if (nums[head] + nums[left] + nums[right] - target == 0) {
                    return res;
                } else if(nums[head] + nums[left] + nums[right] - target > 0) {
                    right--;
                    while(left < right && nums[right] == nums[right+1])--right;
                } else {
                    left++;
                    while(left < right && nums[left] == nums[left-1])++left;
                }
            }
            head++;
            while(head < nums.length - 1 && nums[head] == nums[head-1])head++;
        }
        return res;
    }
}
