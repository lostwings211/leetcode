import java.util.*;
public class Solution {
    public int longestConsecutive(int[] num) {
        if(num == null || num.length == 0) {
            return 0;
        }
        HashSet<Integer> set =  new HashSet<Integer>();
        for(int curr : num) {
            set.add(curr);
        }
        int max = 0;
        
        for(int curr : num) {
            int count = 1;
            int left = curr -1;
            int right = curr + 1;
            
            while(set.contains(left)) {
                set.remove(left);
                count++;
                left--;
            }
            
            while(set.contains(right)) {
                set.remove(right);
                count++;
                right++;
            }
            set.remove(curr);
            max = Math.max(max, count);
        }
        return max;
    }
}
