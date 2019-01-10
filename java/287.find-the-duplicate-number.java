class Solution {
    public int findDuplicate(int[] nums) {
        Set<Integer> store = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!store.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}
