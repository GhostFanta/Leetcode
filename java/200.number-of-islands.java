class Solution {
    public int numIslands(char[][] grid) {
        int res = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1'){
                    res++;
                    travel(grid, i, j);
                }
            }
        }
        return res;
    }

    public void travel(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1'){
            return;
        }

        grid[x][y] = '9';
        travel(grid, x - 1, y);
        travel(grid, x + 1, y);
        travel(grid, x, y - 1);
        travel(grid, x, y + 1);
    }
}
