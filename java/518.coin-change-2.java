class Solution {
    public int change(int amount, int[] coins) {
        int[] res = new int[amount + 1];
        
        res[0] = 1;
        for(int j = 0 ; j < coins.length; j++){
            for(int i = coins[j] ; i <= amount ; i++){
                res[i] = res[i] + res[i - coins[j]];
            }
        }
        return res[res.length - 1];
    }
}
