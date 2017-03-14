public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> item = new ArrayList<Integer>();
        boolean[] visited = new boolean[nums.length];
        dfs(ret, item, visited, 0, k, 2, nums);
        return ret.size();
    }
    
    public void dfs(List<List<Integer>> ret, List<Integer> item, boolean[] visited, int start, int k, int count, int[] nums) {
        if(item.size() == count) {
            ret.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start; i < nums.length; i++) {
            if(i == 0 || nums[i] != nums[i-1] || visited[i-1] == true) {
                if(item.size() == 0 || item.get(item.size() - 1) + k == nums[i]) {
                    visited[i] = true;
                    item.add(nums[i]);
                    dfs(ret,item, visited, i + 1, k, count, nums);
                    item.remove(item.size() - 1);
                    visited[i] = false;           
                }
                else if (item.get(item.size() - 1) + k < nums[i]) {
                    break;
                }
            }
        }
    }
}
