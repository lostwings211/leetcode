import java.util.*;
public class Solution {
    public int maximumGap(int[] num) {
        if(num.length <  2) {
            return 0;
        }
        int max =  0;
        Arrays.sort(num);
        for(int i = 0; i < num.length - 1; i++) {
            if(Math.abs(num[i+1] -  num[i]) > max) {
                max = Math.abs(num[i+1] -  num[i]);
            }
        }
        return max;
    }
}
