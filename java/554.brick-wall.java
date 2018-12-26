class Solution {
    public int leastBricks(List<List<Integer>> wall) {
       Map<Integer, Integer> store = new HashMap<>();
       for(List<Integer> cur : wall){
           int sum = 0;
           for(Integer i = 0 ; i < cur.size() - 1  ; i++){
                   sum += cur.get(i);
                   store.put(sum, store.getOrDefault(sum, 0) + 1);
           }
       }

       int res = 0;
       for(Integer i : store.keySet()){
           res = res > store.get(i) ? res : store.get(i);
       }

       return wall.size() - res;
    }
}
