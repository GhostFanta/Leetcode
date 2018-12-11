import java.lang.*;
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];
        if(board[x][y] == 'M'){
            board[x][y] = 'X';
            return board;
        }
        if(board[x][y] == 'E'){
            travel(board,x,y);
        }
        return board;
    }

    public void travel(char[][] board, int x, int y){

        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != 'E'){
            return;
        }
        int num = numOfMines(board,x,y);
        if(num == 0){
            board[x][y] = 'B';
            travel(board, x - 1, y);
            travel(board, x - 1, y - 1);
            travel(board, x - 1, y + 1);
            travel(board, x + 1, y);
            travel(board, x + 1, y + 1);
            travel(board, x + 1, y - 1);
            travel(board, x, y + 1);
            travel(board, x, y - 1);
        } else {
            board[x][y] = Character.forDigit(num,10);
        }
    }

    public int numOfMines(char[][] board, int x, int y){
        int res = 0;
        if(x - 1 >= 0){
            if(y - 1 >= 0 && board[x - 1][y - 1] == 'M'){
                ++res;
            }
            if(y + 1 < board[0].length && board[x - 1][y + 1] == 'M'){
                ++res;
            }
            if(board[x-1][y] == 'M'){
                ++res;
            }
        }
        if(y - 1 >= 0 && board[x][y-1] == 'M'){
            ++res;
        }
        if(y + 1 < board[0].length && board[x][y+1] == 'M'){
            ++res;
        }
        if(x + 1 < board.length){
            if(y - 1 >= 0 && board[x+1][y-1] == 'M'){
                ++res;
            }
            if(y + 1 < board[0].length && board[x+1][y+1] == 'M'){
                ++res;
            }
            if(board[x+1][y] == 'M'){
                ++res;
            }
        }
        return res;
    }
}
