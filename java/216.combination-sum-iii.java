class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> store = new ArrayList<>();
        helper(store, new ArrayList<Integer>(), n, 1, k, n, new HashSet<Integer>(), 0);
        return store;
    }

    public void helper(List<List<Integer>> store, List<Integer> cur, int sum, int index,int k, int n, Set<Integer> use, int dep){

        if(sum < 0|| cur.size() > k){
            return;
        }
        if(sum == 0 && cur.size() == k){
            store.add(new ArrayList<Integer>(cur));
            return;
        }

        for(int i = index; i <= 9 ; i++){
            if(!use.add(i)){
                continue;
            }
            cur.add(i);
            sum -= i;
            helper(store,cur, sum, i + 1, k, n, use, dep + 1);
            cur.remove(cur.size() - 1);
            use.remove(i);
            sum += i;
        }
    }
}
