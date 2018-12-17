class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> store = new ArrayList<>();
        helper(store, new ArrayList<Integer>(), n, k, 0);
        return store;
    }

    public void helper(List<List<Integer>> store, List<Integer> cur, int n, int k, int index){
        if(cur.size() == k){
            store.add(new ArrayList<Integer>(cur));
            return;
        };

        for(int i = index ; i < n; i++){
            cur.add(i + 1);
            helper(store, cur, n, k, i + 1);
            cur.remove(cur.size() - 1);
        }
    }
}
