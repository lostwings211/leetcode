public class Solution {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) {
            return s.length() == 0;
        }
        if(p.length() == 1) {
            return (s.length() == 1 && (s.charAt(0) ==  p.charAt(0) || p.charAt(0) == '.'));
        }
        
        if(p.charAt(1) !=  '*') {
            if(s.length() < 1) {
                return false;
            }
            else if(p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)) {
                return false;
            }
            else {
                return isMatch(s.substring(1), p.substring(1));
            }
        }
        else if (p.charAt(1) == '*') {
            if(p.charAt(0) == '.') {
                for(int i = 0; i <= s.length(); i++) {
                    boolean isValid = false;
                    isValid = isMatch(s.substring(i, s.length()), p.substring(2));
                    if(isValid) {
                        return true;
                    }
                }
            }
            else {
                boolean isValid = false;
                isValid = isMatch(s, p.substring(2));
                if(isValid) {
                    return true;
                }
                int i = 0;
                while (i < s.length() && s.charAt(i) == p.charAt(0)) {
                    boolean isValid1 = false;
                    isValid1 = isMatch(s.substring(i+1, s.length()), p.substring(2));
                    if(isValid1) {
                        return true;
                    }
                    i++;
                }
            }
        }
        return false;
    }
}
