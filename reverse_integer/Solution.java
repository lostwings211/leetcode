public class Solution {
    public int reverse(int x) {
        int ret = 0;
        long ret_long = 0;
        boolean negative = false;
        if (x < 0) {
            x = -x;
            negative = true;
        }
        while(x > 0) {
            ret = 10*ret + x%10;
            ret_long = 10*ret_long + x%10;
            if(ret_long > (long)ret) {
                //there is integer overflow
                return 0;
            }
            x = x / 10;
            System.out.println(ret + ": " + x );
        }
        if(negative == true) {
            ret = -ret;
        }
        return ret;
    }
}
