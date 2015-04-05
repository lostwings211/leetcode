public class Solution {
    public int findPeakElement(int[] num) {
        for(int i = 0; i < num.length; i++) {
            int prev = Integer.MIN_VALUE;
            int next = Integer.MIN_VALUE;
            if(i > 0) {
                prev = num[i-1];
            }
            if(i < num.length - 1) {
                next = num[i+1];
            }
            if(num[i] > prev && num[i] > next) {
                return i;
            }
        }
        return 0;
    }
}
