class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < 32 ; i++){
            int sum = 0;
            for(int j = 0 ; j < nums.length ; j++){
                if(((1 << i) & nums[j]) != 0){
                    sum++;
                }
            }
            res |= ((sum % 3) << i);
        }

        return res;
    }
}
