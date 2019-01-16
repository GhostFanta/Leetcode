class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix == null){
            return false;
        }

        boolean res = false;

        int i = 0;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(matrix[i][j] == target){
                res = true;
                break;
            }
            if(matrix[i][j] < target){
                i++;
            } else {
                j--;
            }
        }
        return res;
    }
}
