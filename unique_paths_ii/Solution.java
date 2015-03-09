public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if(m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if(n == 0) {
            return 0;
        }
        
        int[][] cost = new int[m][n];
        int i = 0;
        for(i = 0; i < n; i++) {
            if(obstacleGrid[0][i] == 0) {
                cost[0][i] = 1;
            }
            else {
                cost[0][i] = 0;
                break;
            }
        }
        for(int index = i + 1; index < n; index++) {
            cost[0][index] = 0;    
        }
        
        for(i = 0; i < m; i++) {
            if(obstacleGrid[i][0] == 0) {
                cost[i][0] = 1;
            }
            else {
                cost[i][0] = 0;
                break;
            }
        }
        for(int index = i + 1; index < m; index++) {
            cost[index][0] = 0;
        }
        
        for(i = 1; i < m; i++) 
            for(int j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 1) {
                    cost[i][j] = 0;
                }
                else {
                    cost[i][j] = cost[i-1][j] + cost[i][j-1];
                }
            }
        
        return cost[m-1][n-1];
    }
}
