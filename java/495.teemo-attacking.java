class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0){
            return 0;
        }
        if(timeSeries.length == 1){
            return timeSeries[0] + duration - 1;
        }
        int left = timeSeries[0];
        int right = left + duration - 1;
        int res = 0;
        for(int i = 1 ; i < timeSeries.length; i++){
            if(right >= timeSeries[i]){
                right = timeSeries[i] + duration - 1;
            } else {
                res += (right - left + 1);
                left = timeSeries[i];
                right = left + duration - 1;
            }
        }
        res += (right - left + 1);
        return res;
    }
}
