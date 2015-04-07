import java.util.*;
public class Solution {
    public int trailingZeroes(int n) {
        ArrayList<Long> counts =  new ArrayList<Long>();
        long ret = 0;
        long dividend = 5;
        long double_n = (long)n;
        while(double_n/dividend > 0) {
            counts.add(double_n/dividend);
            dividend *=  5;
        }
        if(counts.size() > 0) {
            for(int i = counts.size() - 1; i >= 0; i--) {
                if(i == counts.size() - 1) {
                    ret +=  (i + 1) * counts.get(i);
                }
                else {
                    ret +=  (i + 1) * (counts.get(i) - counts.get(i+1));
                }
            }
        } 
        return (int)ret;
    }
}
