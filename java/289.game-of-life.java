class Solution {
    // 0: dead->dead 1: live->live 2:live->dead 3: dead->live
    public void gameOfLife(int[][] board) {
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                go(board, i, j);
            }
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 0 || board[i][j] == 2){
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
            }
        }
    }

    public void go(int[][] board, int x, int y){
        if(x < 0 || x > board.length || y < 0 || y > board[0].length){
            return;
        }

        int res = 0;
        if(x - 1 >= 0){
            res += (board[x - 1][y] == 1 || board[x - 1][y] == 2) ? 1 : 0;
            if(y - 1 >=0){
                res += (board[x - 1][y - 1] == 1 || board[x - 1][y - 1] == 2) ? 1 : 0;

            }
            if(y + 1 < board[0].length){
                res += (board[x - 1][y + 1] == 1 || board[x - 1][y + 1] == 2) ? 1 : 0;
            }
        }
        if(y - 1 >=0){
            res += (board[x][y - 1] == 1 || board[x][y - 1] == 2) ? 1 : 0;
        }
        if(y + 1 < board[0].length){
            res += (board[x][y + 1] == 1 || board[x][y + 1] == 2) ? 1 : 0;

        }
        if(x + 1 < board.length){
            res += (board[x + 1][y] == 1 || board[x + 1][y] == 2) ? 1 : 0;
            if(y - 1 >=0){
                res += (board[x + 1][y - 1] == 1 || board[x + 1][y - 1] == 2) ? 1 : 0;
            }
            if(y + 1 < board[0].length){
                res += (board[x + 1][y + 1] == 1 || board[x + 1][y + 1] == 2) ? 1 : 0;
            }
        }
        if(res < 2 || res > 3){
            if(board[x][y] == 0){
                board[x][y] = 0;
            } else {
                board[x][y] = 2;
            }
        } else if (res == 2){
            if(board[x][y] == 0){
                board[x][y] = 0;
            } else {
                board[x][y] = 1;
            }
        } else if(res == 3){
            if(board[x][y] == 0){
                board[x][y] = 3;
            } else {
                board[x][y] = 1;
            }
        }
        
    }
}
