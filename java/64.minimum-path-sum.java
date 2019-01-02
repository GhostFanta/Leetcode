class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(i == 0 && j == 0){
                    continue;
                }

                long left = Integer.MAX_VALUE;
                long top = Integer.MAX_VALUE;

                if(i - 1 >= 0){
                    left = grid[i - 1][j];
                }

                if(j - 1 >= 0){
                    top = grid[i][j - 1];
                }

                grid[i][j] = (int)Math.min(left + grid[i][j], top + grid[i][j]);
            }
        }

        return grid[grid.length - 1][grid[0].length - 1];
    }
}
