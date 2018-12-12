class Solution {
    public int uniquePaths(int m, int n) {

        int[][] path = new int[m][n];
        path[0][0] = 1;

        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                int top = j - 1;
                int left = i - 1;
                if(top >= 0){
                    path[i][j] += path[i][top];
                }
                if(left >= 0){
                    path[i][j] += path[left][j];
                }
            }
        }
        return path[path.length - 1][path[0].length - 1];
    }
}
