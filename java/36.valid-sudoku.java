class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<HashSet<Integer>> store = new ArrayList<>();

        for(int i = 0 ; i < 9 ; i++){
            store.add(new HashSet<Integer>());
        }

        for(int x = 0 ; x < 9 ; x++){
            Set<Integer> col = new HashSet<>();
            for(int y = 0 ; y < 9 ; y++){
                if(board[x][y] == '.'){
                    continue;
                }
                if(!col.add(Integer.parseInt(String.valueOf(board[x][y])))){
                    return false;
                }
            }
        }

        for(int y = 0 ; y < 9 ; y++){
            Set<Integer> row = new HashSet<>();
            for(int x = 0 ; x < 9 ; x++){
                if(board[x][y] == '.'){
                    continue;
                }
                if(!row.add(Integer.parseInt(String.valueOf(board[x][y])))){
                    return false;
                }
            }
        }

        
        for(int x = 0 ; x < 9 ; x++){
            for(int y = 0 ; y < 9 ; y++){
                if(board[x][y] == '.'){
                    continue;
                }
                int seq = x / 3 * 3 + y / 3;
                if(!store.get(seq).add(Integer.parseInt(String.valueOf(board[x][y])))){
                    return false;
                }
            }
        }

        return true;
    }
}
