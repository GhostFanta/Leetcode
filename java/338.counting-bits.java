class Solution {
    public int[] countBits(int num) {
        int[] store = new int[num + 1];
        for(int i = 0 ; i <= num; i++){
            if(i % 2 == 0)
                store[i] = store[i / 2];
            else
                store[i] = store[i / 2] + 1;
        }
        return store;
    }
}
