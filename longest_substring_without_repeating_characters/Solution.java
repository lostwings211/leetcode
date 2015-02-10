import java.util.*;
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int curr_len = 0;
        int max_len = 0;
        int[] indexes = new int[2];
        int[] visited =  new int[1024]; 
        Arrays.fill(visited, -1);
        Arrays.fill(indexes, 0);
        char[] charArray = s.toCharArray();        
        for (int i = 0; i < charArray.length; i++) {
            char curr_char = charArray[i];
            int last_index = visited[(int)curr_char];
            
            if (last_index == -1 || last_index < i - curr_len) {
                curr_len++;
            }
            else {
                curr_len = i - last_index;
            }
            if (curr_len >= max_len) {
                max_len = curr_len;
                indexes[0] =  i - max_len + 1;
                indexes[1] =  i;
            }
            visited[(int)curr_char] = i;
        } 
        return max_len;
    }
}
