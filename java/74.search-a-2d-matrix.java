class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int left = 0;
        int right = matrix.length - 1;

        int row = 0;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(matrix[mid][0] == target) {
                return true;
            } else if(matrix[mid][0] < target) {
                if(mid + 1 >= matrix.length || mid + 1 < matrix.length && 
                        matrix[mid + 1][0] > target) {
                    row = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }

        left = 0;
        right = matrix[0].length - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if(matrix[row][mid] == target){
                return true;
            } else if( matrix[row][mid] > target){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}
