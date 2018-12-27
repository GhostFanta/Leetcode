class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length < 1){
            return 0;
        }
        int[][] step = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] != 1){
            step[0][0] = 1;
        }
        for(int i = 0 ; i < obstacleGrid.length ; i++){
            for(int j = 0 ; j < obstacleGrid[0].length ; j++){
                if(obstacleGrid[i][j] == 1){
                    continue;
                }

                if(i - 1 >= 0 && obstacleGrid[i - 1][j] != 1){
                    step[i][j] += step[i - 1][j];
                }

                if(j - 1 >= 0 && obstacleGrid[i][j - 1] != 1){
                    step[i][j] += step[i][j - 1];
                }
            }
        }
        return step[step.length - 1][step[0].length - 1];
    }
}
