import java.util.*; 
public class Solution {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        boolean last_added = false;
        for(int i = 0; i < intervals.size(); i++) {
            Interval curr_interval = intervals.get(i);
            if(last_added == true) {
                ret.add(curr_interval);
            }
            else if(overlap(curr_interval, newInterval) == true) {
                newInterval.start =  Math.min(curr_interval.start, newInterval.start);
                newInterval.end =  Math.max(curr_interval.end, newInterval.end);
            }
            else {
                if(curr_interval.start < newInterval.start) {
                    ret.add(curr_interval);    
                }
                else {
                    ret.add(newInterval);
                    ret.add(curr_interval);
                    last_added = true;
                }
            }
        }
        if(!last_added) {
            ret.add(newInterval);
        }
        return ret;
    }
    
    public boolean overlap(Interval p1, Interval p2) {
        if(p1.end < p2.start || p2.end < p1.start) {
            return false;
        }
        else {
            return true;
        }
    }
}
