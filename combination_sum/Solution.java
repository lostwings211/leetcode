import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(candidates == null || candidates.length == 0) {
            return ret;
        }
        ArrayList<Integer> item = new ArrayList<Integer>();    
        Arrays.sort(candidates);
        dfs(candidates, target, 0, item, ret);
        return ret;
    }
    
    public void dfs(int[] candidates, int target, int start, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> ret) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int i = start ; i < candidates.length; i++) {
            int new_target =  target - candidates[i];
            item.add(candidates[i]);
            dfs(candidates, new_target, i, item, ret);
            item.remove(item.size()-1); 
        }
        return;
    }
}
