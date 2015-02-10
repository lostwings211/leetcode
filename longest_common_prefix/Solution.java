public class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        int min_strlen = 0;
        if (strs.length > 0 ) {
            min_strlen = strs[0].length();
        }
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < min_strlen) {
                min_strlen = strs[i].length();
            }    
        }
        
        outerloop:
        for(int index = 0; index < min_strlen; index++) {
            char curr_char =  strs[0].charAt(index);
            for(int i = 1; i < strs.length; i++) {
                if(strs[i].charAt(index) != curr_char) {
                    break outerloop;
                }       
            }
            sb.append(curr_char);
        }
        return sb.toString();
    }
}
