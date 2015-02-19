public class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == Integer.MIN_VALUE && divisor == -1 ) {
            return Integer.MAX_VALUE;
        }
        boolean positive = false;
        long a = (long) dividend;
        long b = (long) divisor;
        positive = (a > 0 && b> 0) || (a < 0 && b < 0);
        a = (a > 0) ? a : 0 - a;
        b = (b > 0) ? b : 0 - b;
        
        if( a == 0 || b == 0) return 0;
        
        int ret = 0;
        int pow = 0;
        long sum = b;
        while( a >= b) {
            pow =  1;
            sum = b;
            while(sum + sum < a) {
                sum = sum + sum;
                pow = pow + pow;
            }
            a = a - sum;
            ret +=  pow;
        }
        return positive ? ret : 0 - ret;
    }
}
