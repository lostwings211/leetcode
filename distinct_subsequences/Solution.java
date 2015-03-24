public class Solution {
    public int numDistinct(String S, String T) {
        if(S == null || T == null || S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
            return 0;
        }
        int dp[][] = new int[T.length()][S.length()];
        for(int i = 0; i < T.length(); i++) {
            for(int j = i; j < S.length(); j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = (T.charAt(i) == S.charAt(j)) ? 1 : 0;
                }
                else if(T.charAt(i) == S.charAt(j)) {
                    if(i >= 1) {
                        dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                    }
                    else {
                        dp[i][j] = dp[i][j-1] + 1;
                    }
                }
                else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[T.length() -1][S.length() -1];
    }
}
