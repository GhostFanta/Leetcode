class Solution {
    public boolean canJump(int[] nums) {
        int prevmax = -1;
        int max = 0;
        int next = 0;
        for(int i = 0 ; i < nums.length ;){
            if(prevmax == max){
                return false;
            }
            for(int j = i ; j <= Math.min(max, nums.length - 1) ; j++){
                if(max <= j + nums[j]){
                    prevmax = max;
                    max = j + nums[j];
                    next = j;
                }
            }
            i = next;
            if(max >= nums.length - 1){
                return true;
            }
        }

        return true;
    }
}
