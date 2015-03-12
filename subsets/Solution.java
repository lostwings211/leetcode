import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ret.add(new ArrayList<Integer>());
        if(S.length == 0) {
            return ret;
        }
        Arrays.sort(S);
        for(int i = 1; i <= S.length; i++) {
            ArrayList<ArrayList<Integer>> curr_ret = subsets_fixed(S, i);
            for(ArrayList<Integer> curr_item :  curr_ret) {
                ret.add(curr_item);
            }
        }
        return ret;
    }

    public ArrayList<ArrayList<Integer>> subsets_fixed(int[]  S, int k) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        dfs(0, S, k, item, ret);
        return ret;
    }

    public void dfs(int start, int[] S, int k, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> ret) {
        if(item.size() == k) {
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        else {
            for(int i = start; i < S.length; i++){
                item.add(S[i]);
                dfs(i+1, S, k, item, ret);
                item.remove(item.size() -1);
            }
        }
    }
}
