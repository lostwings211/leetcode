public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int ret = 0;
        int i = 0;
        while (i < s.length()) {
            ret =  ret * 26 + Convert(s.charAt(i));
            i++;
        }
        return ret;
    }
    
    public int Convert(char curr) {
        return curr - 'A' + 1;
    }
}
