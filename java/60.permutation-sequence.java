class Solution {
    private int seq;
    private String res;
    public String getPermutation(int n, int k) {
        helper(new ArrayList<Integer>(), n, k, new int[n]);
        return res;
    }
    
    public void helper(List<Integer> store, int n, int k, int[] flag){
        if(store.size() == n){
            this.seq++;
            if(k == this.seq){
                StringBuilder sb = new StringBuilder();
                for(Integer i : store){
                    sb.append(i);
                }
                this.res = sb.toString();
            }
            return;
        }

        if(k == this.seq){
            return;
        }

        for(int i = 1 ; i <= n  ; i++){
            if(flag[i - 1] == 1){
                continue;
            }
            flag[i - 1] = 1;
            store.add(i);
            helper(store, n, k, flag);
            store.remove(store.size() - 1);
            flag[i - 1] = 0;
        }
    }
}
