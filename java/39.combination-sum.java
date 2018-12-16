class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), candidates, 0, 0, target);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> cur, int[] candidates, int index, int sum, int target){
        if(sum > target){
            return;
        }
        if(sum == target){
            res.add(new ArrayList<Integer>(cur));
        }

        for(int i = index ; i < candidates.length ; i++){
            cur.add(candidates[i]);
            sum+=candidates[i];
            this.helper(res, cur, candidates, i, sum, target);
            cur.remove(cur.size() - 1);
            sum-=candidates[i];
        }
    }
}
