public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return true;
        }
        String s_lower = s.toLowerCase();
        int i = 0;
        int j = s_lower.length() - 1;
        
        while(i < j) {
            char curr_left = s_lower.charAt(i);
            char curr_right = s_lower.charAt(j);
            if(is_alphanumeric(curr_left) == false) {
                i++;
                continue;
            }
            if(is_alphanumeric(curr_right) == false) {
                j--;
                continue;
            }
            if(curr_left !=  curr_right) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
    public boolean is_alphanumeric(char c) {
        if ((c - 'a' >= 0 && c - 'a' <= 25) ||
            (c - '0' >= 0 && c - '0' <= 9)) {
                return true;
            }
        else {
            return false;
        }
    }
}
