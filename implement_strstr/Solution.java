public class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle ==  null) return -1;
        int length_h = haystack.length();
        int length_n = needle.length();
        if(length_h < length_n) return -1;
        
        for(int i = 0; i <= length_h - length_n; i++) {
            boolean found = true;
            for(int j = 0; j < length_n; j++) {
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found == true) return i;
        }
        return -1;
    }
}
