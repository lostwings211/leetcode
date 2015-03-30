public class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean isPal[][] = new boolean[n][n];
        int cut[] = new int[n];
        for (int j = 0; j < n; j++) {
            cut[j] = j;
            for (int i = j; i >= 0; i--) {
                if (s.charAt(i) == s.charAt(j) && 
                    (j - i <= 1 || isPal[i + 1][j - 1])) {
                    isPal[i][j] = true;
                    if (i > 0) {
                        cut[j] = Math.min(cut[j], cut[i - 1] + 1);
                    }
                    else {
                        cut[j] = 0;  
                    }
                }
            }
        }
        return cut[n - 1];
    }
}
