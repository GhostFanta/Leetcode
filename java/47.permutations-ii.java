class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> store = new ArrayList<>();
        boolean[] flag = new boolean[nums.length];
        helper(store, new ArrayList<>(), nums, flag);
        return store;
    }

    public void helper(List<List<Integer>> store, List<Integer> cur, int[] nums, boolean[] flag){
        if(cur.size() == nums.length){
            store.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i = 0; i < nums.length ; i++) {
            if(flag[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i - 1] && flag[i - 1] == false){
                continue;
            }
            cur.add(nums[i]);
            flag[i] = true;
            helper(store, cur, nums, flag);
            cur.remove(cur.size() - 1);
            flag[i] = false;
        }
    }
}
