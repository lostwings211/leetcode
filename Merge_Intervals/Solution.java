import java.util.*;
public class Solution {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        ArrayList<Interval> ret =  new ArrayList<Interval>();
        if(intervals.size() == 0) {
            return ret;
        }
        ret.add(intervals.get(0));
        if(intervals.size() == 1) {
            return ret;
        }

        for(int i = 1; i < intervals.size(); i++ ) {
            Interval curr_interval =  intervals.get(i);
            ArrayList<Interval> curr_ret = new ArrayList<Interval>();
            for (int j = 0; j < ret.size(); j++) {
                if(overLap(curr_interval, ret.get(j)) == true) {
                    int new_start = Math.min(curr_interval.start, ret.get(j).start);
                    int new_end = Math.max(curr_interval.end, ret.get(j).end);
                    curr_interval.start = new_start;
                    curr_interval.end = new_end;
                }
                else {
                    curr_ret.add(ret.get(j));
                }
            }
            curr_ret.add(curr_interval);
            ret = curr_ret;
        }
        return ret;
    }
    
    public static boolean overLap(Interval interval1, Interval interval2) {
        if(interval1.end < interval2.start || interval1.start > interval2.end) {
            return false;
        }
        else {
            return true;
        }
    }
    
    public static void main(String[] args) {
        ArrayList<Interval> input = new ArrayList<Interval>();
        Interval p1 = new Interval(1,4);
        Interval p2 = new Interval(1,5);
        input.add(p1);
        input.add(p2);

        List<Interval> output = merge(input);
    }
}
