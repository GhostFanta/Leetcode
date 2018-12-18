class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> store = new PriorityQueue<>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
        });

        for(int i = 0 ; i < nums.length ; i++){
            store.add(nums[i]);
        }

        int res = 0;

        while(k > 0){
            res = store.poll();
            --k;
        }
        return res;
    }
}
