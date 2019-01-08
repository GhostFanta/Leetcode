class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] res = new int[triangle.get(triangle.size() - 1).size()];
        int[] temp = new int[triangle.get(triangle.size() - 1).size()];
        
        
        res[0] = triangle.get(0).get(0);
        temp[0] = triangle.get(0).get(0);

        for(int i = 1 ; i < triangle.size() ; i++){
            for(int j =  0 ; j < triangle.get(i).size() ; j++){
                long self = Integer.MAX_VALUE - 1;
                long prev = Integer.MAX_VALUE - 1;

                if(j - 1 >= 0 && j < triangle.get(i).size() - 1){
                    self = res[j];
                    prev = res[j - 1];
                }else if(j - 1 < 0){
                    self = res[j];
                } else if(j >= triangle.get(i).size() - 1){
                    prev = res[j - 1];
                }
                temp[j] = triangle.get(i).get(j) + (int)Math.min(self,prev);
            }
            for(int j = 0 ; j < res.length ; j++){
                res[j] = temp[j];
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0 ; i < res.length ; i++){
            result = result > res[i] ? res[i] : result;
        }

        return result;
    }
}
