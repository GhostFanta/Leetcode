class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> store = new ArrayList<>();
        helper(store, new ArrayList<>(), nums, 0);
        return store;
    }

    public void helper(List<List<Integer>> store,List<Integer> cur, int[] nums, int index){
        store.add(new ArrayList<Integer>(cur));

        for(int i = index ; i < nums.length ; i++){
            cur.add(nums[i]);
            helper(store, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
    } 
}
