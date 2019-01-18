class Solution {
    private int count;
    public int triangleNumber(int[] nums) {
        this.count = 0;
        Arrays.sort(nums);
        int first = 0;
        for(; first < nums.length - 2; first++){
            int second = first + 1;
            for(; second < nums.length - 1 && nums[first] != 0; second++){
                int third = second + 1;
                while(third < nums.length && nums[first] + nums[second] > nums[third]){
                    third++;
                }
                count += (third - second - 1);
            }
        }
        return this.count;
    }
}
