/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }

        Arrays.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.end - b.end;
            }
        });

        List<Interval> store = new ArrayList<>();
        int end = intervals[0].end;
        store.add(intervals[0]);
        for(int i = 0 ; i < intervals.length ; i++){
            if(intervals[i].start >= end){
                end = intervals[i].end;
                store.add(intervals[i]);
            }
        }
        return intervals.length - store.size();
    }
}


// class Solution {
//     public int eraseOverlapIntervals(Interval[] intervals) {
//         if(intervals == null || intervals.length == 0){
//             return 0;
//         }
//         Arrays.sort(intervals, new Comparator<Interval>(){
//             public int compare(Interval a, Interval b){
//                 if(a.start == b.start){
//                     return a.end - b.end;
//                 }
//                 return a.start - b.start;
//             }
//         });

//         List<Interval> store = new ArrayList<>();
        
//         int start = intervals[0].start;
//         int end = intervals[0].end;
//         store.add(intervals[0]);
//         for(int i = 0 ; i < intervals.length ; i++){
//             if(intervals[i].start == start){
//                 continue;
//             } else if(intervals[i].start >= end) {
//                 if(intervals[i].end != end){
//                     start = intervals[i].start;
//                     end = intervals[i].end;
//                     store.add(intervals[i]);
//                 }
//             }
//         }
//         return intervals.length - store.size();
//     }
// }
