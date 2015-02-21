public class Solution {
    public boolean isPalindrome(int x) {
        long x_long = x;
        boolean negative = x_long < 0 ? true : false;
        long x_reverse = 0;
        
        while(x_long > 0) {
            x_reverse = 10 * x_reverse + x_long % 10;
            x_long = x_long / 10;
        }
        
        x_reverse = negative ? -x_reverse : x_reverse;
        if(x_reverse == (long)x) {
            return true;
        }
        else {
            return false;
        }
    }
}
