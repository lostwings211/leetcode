import java.util.*;
public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> ret =  new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> item = new ArrayList<Integer>();
        Arrays.sort(num);
        boolean visited[] =  new boolean[num.length];
        dfs(num, visited, item, ret);
        return ret;
    }
    
    public void dfs(int[] num, boolean[] visited, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> ret) {
        if(item.size() == num.length){
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        else {
            for(int index = 0; index < num.length; index++) {
                if(visited[index] == false) {
                    if ((index == 0) || 
                        (num[index] != num[index-1]) ||
                        (visited[index-1]  == true)) {
                            visited[index] =  true;
                            item.add(num[index]);
                            dfs(num, visited, item, ret);
                            visited[index] = false;
                            item.remove(item.size() -1);
                        }
                }
            }       
        }
    }
}
