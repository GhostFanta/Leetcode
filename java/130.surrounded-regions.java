class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length < 1){
            return;
        }
        for(int i = 0 ; i < board[0].length ; i++ ){
            travel(board, 0, i);
            travel(board, board.length - 1, i);
        }

        for(int i = 0 ; i < board.length; i++){
            travel(board, i, 0);
            travel(board, i, board[0].length - 1);
        }

        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
                if(board[i][j] == '-'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void travel(char[][] board, int x, int y){
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'O'){
            return;
        }

        board[x][y] = '-';
        travel(board, x - 1, y);
        travel(board, x + 1, y);
        travel(board, x, y - 1);
        travel(board, x, y + 1);
    }
}
