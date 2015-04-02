import java.util.*;
public class Solution {
    public String reverseWords(String s) {
        if(s == null) {
            return s;
        }
        s = s.trim();
        if(s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        int i = 0;
        while( i < s.length()) {
            if(s.charAt(i) == ' ') {
                if(sb.length() == 0) {
                    sb.insert(0, s.substring(curr, i));
                }
                else {
                    sb.insert(0, s.substring(curr, i) + " ");
                }
                while(s.charAt(i+1) == ' ') {
                    i++;
                }
                curr = i + 1;
                i = curr;
            }
            i++;
        }
        if(sb.length() == 0) {
            sb.insert(0, s.substring(curr, i));
        }
        else {
            sb.insert(0, s.substring(curr, i) + " ");
        }
        
        return sb.toString();
    }
}
