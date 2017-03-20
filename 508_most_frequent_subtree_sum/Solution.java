/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        TreeSum(map, root);
        int max = Integer.MIN_VALUE;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int key : map.keySet()) {
            if(map.get(key) > max) {
                max = map.get(key);
                ret = new ArrayList<Integer>();
                ret.add(key);
            }
            else if(map.get(key) == max) {
                ret.add(key);
            }
        }
        int[] ret_array = new int[ret.size()];
        for(int i = 0; i < ret_array.length; i++) {
            ret_array[i] = ret.get(i);
        }
        return ret_array;
    }
    
    public int TreeSum(HashMap<Integer, Integer> map, TreeNode root) {
        if(root.left == null && root.right == null) {
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            return root.val;
        }
        int curr_val = root.val;
        if(root.left != null) {
            curr_val += TreeSum(map, root.left);
        }
        if(root.right != null) {
            curr_val += TreeSum(map, root.right);
        }
        map.put(curr_val, map.getOrDefault(curr_val, 0) + 1);
        return curr_val;
    }
}
