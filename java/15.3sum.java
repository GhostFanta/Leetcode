class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> store = new ArrayList<>();

        if(nums.length < 3){
            return store;
        }

        for(int head = 0 ; head < nums.length - 2;){
            int mid = head + 1;
            int tail = nums.length - 1;
            while(mid < tail){
                int res = nums[head] + nums[mid] + nums[tail];

                if(res == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[head]);
                    temp.add(nums[mid]);
                    temp.add(nums[tail]);
                    store.add(temp);
                    // Move the anchor and do dup check based on the previous element
                    ++mid;
                    --tail;
                    // Dup check will only be available once a match is found
                    while(mid < tail && nums[mid-1] == nums[mid])++mid;
                    while(mid < tail && tail != nums.length - 1 && nums[tail] == nums[tail+1])--tail;

                } else if(res > 0){
                    --tail;
                } else {
                    ++mid;
                }
            }
            while(head < nums.length - 2 && nums[head] == nums[++head]);
        }

        return store;
    }
}
