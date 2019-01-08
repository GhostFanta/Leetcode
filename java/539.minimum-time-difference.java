class Solution {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints.size() < 2){
            return 0;
        }
        int[] store = new int[timePoints.size() + 2];
        int index = 1;
        int anchor = 24 * 60;
        store[store.length - 1] = anchor;
        for(String i : timePoints){
            String[] comp = i.split(":");
            int hm = Integer.parseInt(comp[0]);
            int mm = Integer.parseInt(comp[1]);
            store[index++] = hm * 60 + mm;
        }

        Arrays.sort(store);

        int min = Integer.MAX_VALUE;
        for(int i = 2 ; i < store.length - 1 ; i++){
            min = min > store[i] - store[i - 1] ? store[i] - store[i - 1] : min;
        }

        if(store[store.length - 1] - store[store.length - 2] + store[1] - store[0] < min){
            min = store[store.length - 1] - store[store.length - 2] + store[1] - store[0];
        }
        return min;
    }
}
