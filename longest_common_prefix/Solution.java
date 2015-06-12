public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        int minLength = MinLength(strs);
        String ret = "";
        int index = 0;
        while(index < minLength) {
            for(int i = 1; i < strs.length; i++) {
                if(strs[0].charAt(index) !=  strs[i].charAt(index)) {
                    return ret;
                }
            }
            ret += strs[0].charAt(index);
            index++;
        }
        return ret;
    }
    
    public int MinLength(String[] strs) {
        if(strs == null || strs.length == 0) {
            return 0;
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            if(ret > strs[i].length()) {
                ret = strs[i].length();
            }
        }
        return ret;
    }
}
