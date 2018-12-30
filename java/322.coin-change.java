class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] temp = new int[amount + 1];
        for(int i = 1 ; i <= amount ; i++){
            temp[i] = amount + 1;
        }

        for(int i = 0 ; i <= amount ; i++){
            for(int j = 0 ; j < coins.length ; j++){
                if(i - coins[j] >= 0){
                    temp[i] = temp[i] < temp[i - coins[j]] + 1 ? temp[i] : temp[i - coins[j]] + 1;
                }
            }
        }

        if(temp[temp.length - 1] != amount + 1 && temp[temp.length - 1] > 0){
            return temp[temp.length - 1];
        } else {
            return -1;
        }
    }
}
