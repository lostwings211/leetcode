public class Solution {
    public int sqrt(int x) {
        long ret = 1;
        long min_diff = Integer.MAX_VALUE;
        long start = 1;
        long end = x;
        long curr =  (start + end) /2;
        while (curr != start) {
            if(curr * curr == (long)x) {
                return (int)curr;
            }
            else if (curr * curr < (long)x) {
                if(((long)x - curr*curr) < min_diff) {
                    ret = curr;
                    min_diff = (long)x - curr*curr;
                }
                start = curr;
            }
            else {
                end = curr;
            }
            curr = (start + end) / 2;
        }
        if(((long)x - curr*curr) < min_diff) {
            ret = curr;
            min_diff = x - curr*curr;
        }
        return (int)ret;
    }
}
