class Solution {
    public int totalHammingDistance(int[] nums) {
        int[] store = new int[32];
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 31 ; j >= 0 ; j--){
                store[j] += ((nums[i] >> j) & 1);
            }
        }

        int res = 0;
        for(int i = 0 ;i < store.length ;i++){
            res += (nums.length - store[i]) * store[i];
        }

        return res;
    }
}
