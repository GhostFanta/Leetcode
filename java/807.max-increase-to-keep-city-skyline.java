class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int L = grid.length;

        int[] vermax = new int[L];
        int[] hormax = new int[L];

        for(int i = 0 ; i < L ; ++i){
            for(int j = 0 ; j < L ; j++){
               vermax[i] = vermax[i] > grid[i][j] ? vermax[i] : grid[i][j];
               hormax[j] = hormax[j] > grid[i][j] ? hormax[j] : grid[i][j];
            }
        }

        int res = 0;
        for(int i = 0 ; i < L; ++i){
            for(int j = 0 ; j < L; ++j){
                res += (Math.min(vermax[i], hormax[j]) - grid[i][j]);
            }
        }

        return res;
    }
}
