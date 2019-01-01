class Solution {
    public int[] singleNumber(int[] nums) {
        int mask = nums[0];
        for(int i = 1 ; i < nums.length ; i++){
            mask ^= nums[i];
        }

        List<Integer> a1 = new ArrayList<>();
        List<Integer> a2 = new ArrayList<>();

        int index = 0;
        for(int i = 0 ; i < 32 ; i++){
            if(((mask >> i) & 1) == 1){
                index = i;
                break;
            }
        }

        for(int i = 0 ; i < nums.length ; i++){
            if(((nums[i] >> index) & 1) == 1){
                a1.add(nums[i]);
            } else {
                a2.add(nums[i]);
            }
        }

        int[] res = new int[2];
        mask = a1.get(0);
        for(int i = 1 ; i < a1.size() ; i++){
            mask ^= a1.get(i);
        }
        res[0] = mask;

        mask = a2.get(0);
        for(int i = 1 ; i < a2.size() ; i++){
            mask ^= a2.get(i);
        }
        res[1] = mask;
        return res;
    }
}
