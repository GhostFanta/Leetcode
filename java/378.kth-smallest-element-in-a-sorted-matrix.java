class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        Set<Integer> dic = new HashSet<Integer>();
        PriorityQueue<Integer> store = new PriorityQueue<>(k, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });
        int count = 0;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                store.add(matrix[i][j]);
            }
        }
        
        int res = 0;
        while(0 < k--){
            res = store.poll();
        }

        return res;
    }
}
