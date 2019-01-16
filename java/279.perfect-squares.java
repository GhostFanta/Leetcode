class Solution {
    public int numSquares(int n) {
        int anchor = (int)Math.sqrt(n);
        int[] coins = new int[anchor];
        for(int i = 0 ; i < coins.length ; i++){
            coins[i] = (i + 1) * (i + 1);
        }

        int[] store = new int[n + 1];
        for(int i = 0 ; i < store.length ; i++){
            store[i] = n;
        }
        store[0] = 0;
        for(int i = 0 ; i < coins.length ; i++){
            for(int j = coins[i] ; j < store.length ; j++){
                store[j] = Math.min(store[j], store[j - coins[i]] + 1);
            }
        }
        return store[n];
    }
}
