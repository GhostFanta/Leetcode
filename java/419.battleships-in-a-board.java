class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length ; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'X'){
                    count++;
                    travel(board,i,j);
                }
            }
        }
        return count;
    }

    public void travel(char[][] board, int x, int y) {
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'X'){
            return;
        }

        board[x][y] = 'O';

        travel(board, x - 1, y);
        travel(board, x + 1, y);
        travel(board, x, y - 1);
        travel(board, x, y + 1);
    }
}
