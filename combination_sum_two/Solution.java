import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) {
            return ret;
        }
        boolean visited[] = new boolean[candidates.length];
        ArrayList<Integer> item = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, item, ret, visited);
        return ret;
    }

    public void dfs(int[] candidates, int target, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> ret, boolean[] visited) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = start ; i < candidates.length; i++) {
            if(i > 0 && 
                candidates[i] == candidates[i-1] && 
                visited[i-1] == false) {
                continue;
            }
            int new_target =  target - candidates[i];
            item.add(candidates[i]);
            visited[i] = true;
            dfs(candidates, new_target, i+1, item, ret, visited);
            item.remove(item.size()-1);
            visited[i] = false;
        }
        return;
    }
}
