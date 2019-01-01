class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> store = new ArrayList<>();
        
        for(int head = 0; head < nums.length - 3;){
            int start = head + 1;
            while(start < nums.length - 2){
                int left = start + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[head] + nums[start] + nums[left] + nums[right];
                    if(sum == target){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[head]);
                        cur.add(nums[start]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        store.add(cur);
                        ++left;
                        --right;
                        while(left < right && nums[left - 1] == nums[left] )++left;
                        while(left < right && nums[right + 1] == nums[right] )--right;
                    } else if(sum < target){
                        left++;
                    } else {
                        --right;
                    }
                }
                ++start;
                while(start < nums.length - 2 && nums[start] == nums[start - 1])start++;
            }
            ++head;
            while(head < nums.length - 3 && nums[head] == nums[head - 1])head++;
        }
        return store;
    }
}
