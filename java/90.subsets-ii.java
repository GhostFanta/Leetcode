class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> store = new ArrayList<>();
        helper(store, new ArrayList<Integer>(), 0, nums);
        return store;
    }

    public void helper(List<List<Integer>> store, List<Integer> cur, int index, int[] nums){
        store.add(new ArrayList<Integer>(cur));

        for(int i = index ; i < nums.length; i++){
            if(i != index && nums[i] == nums[i - 1]){
                continue;
            }

            cur.add(nums[i]);
            helper(store, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
}
