import java.util.*;
public class Solution {
    public boolean wordBreak(String s, HashSet<String> dict) {
        if(s == null || s.length() == 0) {
            return false;
        }
        boolean dp[] = new boolean[s.length()];
        for(int i = 0; i < dp.length; i++) {
            if(dict.contains(s.substring(0,i+1))) {
                dp[i] = true;
            }
            else {
                for(int j = 1; j <= i; j++) {
                    String substring_second =  s.substring(j, i + 1);
                    if(dp[j-1] && dict.contains(substring_second)) {
                        dp[i] =  true;
                        break;
                    }
                }
            }
        }
        return dp[dp.length -1];
    }
}
