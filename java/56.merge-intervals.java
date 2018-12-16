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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() < 2){
            return intervals;
        }

        List<Interval> res = new ArrayList<>();

        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval a, Interval b){
                return a.start - b.start;
            }
        });

        Interval cur = new Interval(intervals.get(0).start, intervals.get(0).end);

        for(int i = 1 ; i < intervals.size(); i++){
            Interval mem = intervals.get(i);
            if(mem.start <= cur.end){
                cur.end = mem.end > cur.end ? mem.end : cur.end;
            } else {
                res.add(new Interval(cur.start, cur.end));
                cur.start = mem.start;
                cur.end = mem.end;
            }
        }

        res.add(new Interval(cur.start, cur.end));
        return res;
    }
}
