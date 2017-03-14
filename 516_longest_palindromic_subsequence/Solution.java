public class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if(length == 0) {
            return 0;
        }
        int[][] dp =new int[length][length];
        
        for(int line = 0; line < length; line++) {
            for(int i = 0; i < length - line; i++) {
                int j = i + line;
                if(i == j) {
                    dp[i][j] =  1;
                 }
                 else if(s.charAt(i) == s.charAt(j)) {
                     if(j == i + 1) {
                        dp[i][j] = 2;
                     }
                     else {
                         dp[i][j] = dp[i+1][j-1] + 2;    
                     }
                 }
                 else {
                     dp[i][j] = dp[i+1][j] > dp[i][j-1] ? dp[i+1][j] : dp[i][j-1];
                 }
            }
        }
        return dp[0][length -1];
    }
}
