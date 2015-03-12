import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(n <= 0 || k <= 0 || k > n) {
            return ret;
        }
        ArrayList<Integer> item = new ArrayList<Integer>();
    
        boolean visited[] = new boolean[n];
        dfs(n, k, item, visited, ret);
        return ret;
    }

    public void dfs(int n, int k, ArrayList<Integer> item, boolean[] visited, ArrayList<ArrayList<Integer>> ret) {
        if(item.size() == k) {
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        for(int index = 0; index < n; index++) {
            if(visited[index] == false && existsLargeNumberUsed(visited, index, n) == true) {
                visited[index] = true;
                item.add(index+1);
                dfs(n, k, item, visited, ret);
                item.remove(item.size() - 1);
                visited[index] = false;
            }
        }
    }
    
    public boolean existsLargeNumberUsed(boolean[] visited, int index, int n) {
        for(int i = index + 1; i < n; i++) {
            if(visited[i] == true) {
                return false;
            }
        }
        return true;
    }
}
