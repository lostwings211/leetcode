public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() <= 1) {
            return false;
        }
        int length = s.length();
        int half = length / 2;
        for(int i = 1; i <= half; i++) {
            if(length % i == 0) {
                String curr = s.substring(0, i);
                boolean valid = true;
                for(int j = i; j < length; j = j + i) {
                    if(!curr.equals(s.substring(j, j + i))) {
                        valid = false;
                        break;
                    }
                }
                if(valid == true) {
                    return true;
                }
            }
        }
        return false;
    }
}
