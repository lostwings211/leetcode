public class Solution {
    public int uniquePaths(int m, int n) {
        if(m == 0 || n == 0) {
            return 0;
        }
        if(m == 1 || n == 1) {
            return 1;
        }
        
        int cost[][] = new int[m][n];
        for(int i = 1; i < n; i++) {
            cost[0][i] = 1;
        }
        for(int i = 1; i < m; i++) {
            cost[i][0] = 1;
        }
        
        for(int i = 1; i < m; i++) 
            for(int j = 1; j < n; j++) {
                cost[i][j] = cost[i-1][j] + cost[i][j-1];
            }
        
        return cost[m-1][n-1];
     }
}
