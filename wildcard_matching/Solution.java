public class Solution {
    public boolean isMatch(String s, String p) {
        int star = -1;
        int mark = -1;
        int i = 0;
        int j = 0;
        
        while (i < s.length()) {
            if (j < p.length() && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            }   
            else if (j < p.length() && p.charAt(j) == '*') {
                star = j++;
                mark = i;
            }
            else if (star > -1) {
                j = star + 1;
                i = ++mark;
            }
            else {
                return false;
            }
        }
        
        while(j < p.length()) {
            if(p.charAt(j) == '*') {
                j++;
            }
            else {
                break;
            }
        }
        
        return j == p.length();
    }
    
    public boolean isMatch_recursive(String s, String p) {
        int length_s = s.length();
        int length_p = p.length();
        
        
        length_p =  p.length();
        
        if(length_s == 0 && length_p == 0) {
            return true;
        }
        if(length_p == 1 && p.charAt(0) == '*') {
            return true;
        }
        if(length_s == 0 ||length_p == 0) {
            return false;
        }
        
        int i = 0; 
        while( i < length_s && i < length_p) {
            if(p.charAt(i) != '*') {
                if(s.charAt(i) != p.charAt(i) && p.charAt(i) != '?') {
                    return false;
                }    
            }
            else {
                for(int j = i; j <= length_s; j++) {
                    String sub_s = s.substring(j, length_s);
                    String sub_p = p.substring(i + 1, length_p);
                    if(isMatch_recursive(sub_s, sub_p) == true) {
                        return true;
                    }
                }
                return false;
            }
            i++;
        }
        
        if(length_s == length_p) {
            return true;
        }
        else {
            return false;
        }
    }
}
