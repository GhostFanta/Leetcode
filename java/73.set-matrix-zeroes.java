class Solution {
    public void setZeroes(int[][] matrix) {
        boolean flag = false;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i][j] == 0){
                    if(j == 0){
                        flag = true;
                    }
                    if(i == 0){
                        matrix[0][0] = 0;
                    }
                    if(i != 0){
                        matrix[i][0] = 0;
                    }
                    if(j != 0){
                        matrix[0][j] = 0;
                    }
                }
            }
        }
        for(int i = 1 ; i < matrix.length ; i++){
            if(matrix[i][0] == 0){
                for(int j = 0 ; j < matrix[i].length ;j++){
                    matrix[i][j] = 0;
                }
            }
        }

        for(int i = 1 ; i < matrix[0].length ; i++){
            if(matrix[0][i] == 0){
                for(int j = 0 ; j < matrix.length ;j++){
                    matrix[j][i] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int i = 0 ; i < matrix[0].length ;i++){
                 matrix[0][i] = 0;
            }
        }

        if(flag){
            for(int i = 0 ; i < matrix.length ;i++){
                 matrix[i][0] = 0;
            }
        }
    }
}
