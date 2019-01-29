class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> store = new ArrayList<>();
        helper(store, new ArrayList<Integer>(), candidates, target, 0, new int[candidates.length]);
        return store;
    }
    
    public void helper(List<List<Integer>> store, List<Integer> cur, int[] candidates, int target, int index, int[] flag){
        if(target < 0){
            return;
        }
        if(target == 0){
            store.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i = index ; i < candidates.length ; i++){
            if(flag[i] == 1){
                continue;
            }
            if(i >= index + 1  && candidates[i] == candidates[i - 1] && flag[i - 1] != 1){
                continue;
            }
            flag[i] = 1;
            cur.add(candidates[i]);
            target -= candidates[i];
            helper(store, cur, candidates, target, i + 1, flag);
            target += candidates[i];
            cur.remove(cur.size() - 1);
            flag[i] = 0;
        }

    }
}
