import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        int length = num.length;
        if(length <= 0) {
            return ret;
        }
        
        Arrays.sort(num);
        for(int k = 1; k <= num.length; k++) {
            ArrayList<ArrayList<Integer>> k_run = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> item = new ArrayList<Integer>();
            boolean visited[] = new boolean[length];
            dfs(num, 0, k, visited, item, k_run);    
            for(ArrayList<Integer> curr : k_run) {
                ret.add(curr);
            }
        }
        return ret;
    }
    
    public void dfs(int[] num, int i, int k, boolean[] visited, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> ret) {
        if(item.size() == k) {
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        
        for(int index = i; index < num.length; index++) {
            if(visited[index] == false) {
                if(index == 0 || num[index] != num[index-1] || visited[index-1] == true ) {
                    visited[index] = true;
                    item.add(num[index]);
                    dfs(num, index + 1, k, visited, item, ret);
                    item.remove(item.size() -1);
                    visited[index] =  false;
                }
            }
        }
    }
}
