class Obj{
    public int key;
    public int val;
    public Obj(int keyi, int vali){
        this.key = keyi;
        this.val = vali;
    }
}
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> store = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            store.put(nums[i], store.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Obj> res = new PriorityQueue<Obj>(store.keySet().size(), new Comparator<Obj>(){
            public int compare(Obj a, Obj b){
                return b.val - a.val;
            }
        });

        for(Integer i : store.keySet()){
            res.add(new Obj(i,store.get(i)));
        }

        List<Integer> result = new ArrayList<>();
        while( k > 0 ){
            result.add(res.poll().key);
            --k;
        }
        return result;
    }
}
