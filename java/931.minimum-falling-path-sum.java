class Solution {
    public int minFallingPathSum(int[][] A) {
        for(int i = 1 ; i < A.length ; i++){
            for(int j = 0 ; j < A[0].length ; j++){
                int lt = Integer.MAX_VALUE;
                int t = Integer.MAX_VALUE;
                int rt = Integer.MAX_VALUE;

                if(j - 1 >= 0){
                    lt = A[i - 1][j - 1];
                }

                t = A[i - 1][j];

                if(j + 1 < A[0].length){
                    rt = A[i - 1][j + 1];
                }
                A[i][j] = Math.min(Math.min(lt, t),rt) + A[i][j];
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0 ; i < A[0].length ; i++){
            res = res < A[A.length - 1][i] ? res : A[A.length - 1][i];
        }
        return res;
    }
}
