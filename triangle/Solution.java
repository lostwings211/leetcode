import java.util.*;
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) { 
        int size = triangle.size();
        if(size == 0) {
            return 0;
        }
        int dp[] = new int[size];
        for(int i = 0; i < size; i++) {
            for(int j = i; j >= 0; j--) {
                int curr_val = (int)triangle.get(i).get(j);
                if(i == 0 && j == 0) {
                    dp[j] = curr_val;
                }
                else {
                    if(j == i) {
                        dp[j] = dp[j-1] + curr_val;
                    }
                    else if (j == 0) {
                        dp[j] = dp[j] + curr_val;
                    }
                    else {
                        dp[j] = Math.min(dp[j], dp[j-1]) + curr_val;
                    }
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++) {
            if(dp[i] < ret) {
                ret = dp[i];
            }
        }
        return ret;
    }

    public int minimumTotal_squarestorage(List<List<Integer>> triangle) { 
        int size = triangle.size();
        if(size == 0) {
            return 0;
        }
        int dp[][] = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j <= i; j++) {
                int curr_val = (int)triangle.get(i).get(j);
                if(i == 0 && j == 0) {
                    dp[i][j] = curr_val;
                }
                else {
                    if(j == 0) {
                        dp[i][j]  = dp[i-1][j] + curr_val;
                    }
                    else {
                        dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + curr_val;
                    }
                }
            }
        }
        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < size; i++) {
            if(dp[size-1][i] < ret) {
                ret = dp[size-1][i];
            }
        }
        return ret;
    }

    public int minimumTotal_dfs(List<List<Integer>> triangle) {
        int minpath[] = new int[] {Integer.MAX_VALUE};
        dfs(0, 0, 0, triangle, minpath);
        return minpath[0];
    }
    
    public void dfs(int i, int prev_column, int sum, List<List<Integer>> triangle, int[] minpath) {
        if(i == triangle.size()) {
            if(sum < minpath[0]) {
                minpath[0] = sum;
            }
            return;
        }
        if(i == 0) {
            dfs(i+1, prev_column, sum + (int)triangle.get(i).get(prev_column), triangle, minpath);    
        }
        else {
            dfs(i+1, prev_column, sum + (int)triangle.get(i).get(prev_column), triangle, minpath);    
            dfs(i+1, prev_column +  1, sum + (int)triangle.get(i).get(prev_column + 1), triangle, minpath);    
        }
    }
}
