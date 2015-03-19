public class Solution {
    public int numTrees(int n) {
        int cost[] = new int[n+1];
        cost[0] = 1;
        cost[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                cost[i] += cost[i-j]*cost[j-1];
            }
        }
        return cost[n];
    }
    
    public int numTrees_dfs(int n) {
        return dfs(1,n);
    }
    
    public int dfs(int start, int end) {
        int ret = 0;
        if(start >= end) {
            return 1;
        }
        else {
            for(int i = start; i <= end; i++) {
                int left_children = dfs(start, i - 1);
                int right_children = dfs(i + 1, end);
                ret += left_children* right_children;
            }
        }
        return ret;
    }
}
