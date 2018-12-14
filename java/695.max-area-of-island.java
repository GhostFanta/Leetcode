class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    int area = helper(grid, i, j);
                    res = res > area ? res : area;
                }
            }
        }
        return res;
    }

    public int helper(int[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1){
            return 0;
        }

        grid[x][y] = 9;

        return 1 + helper(grid, x - 1, y) +
        helper(grid, x + 1, y) +
        helper(grid, x, y - 1) +
        helper(grid, x, y + 1);
    }
}
