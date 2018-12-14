class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> store = new ArrayList<>();
        boolean[] flags = new boolean[nums.length];
        helper(store, new ArrayList<>(), nums, flags);
        return store;
    }

    public void helper(List<List<Integer>> store, List<Integer> current, int[] nums, boolean[] flag){
        if(current.size() == nums.length){
            List<Integer> temp = new ArrayList<>(current);
            store.add(temp);
        }

        for(int i = 0; i < nums.length ; i++){
            if(flag[i] == false){
                current.add(nums[i]);
                flag[i] = true;
                helper(store, current, nums, flag);
                current.remove(current.size() - 1);
                flag[i] = false;
            }
        }
    }
}
