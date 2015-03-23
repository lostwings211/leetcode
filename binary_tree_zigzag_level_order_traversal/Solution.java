import java.util.*;
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
 
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return ret;
        }
        ArrayList<TreeNode> level_nodes = new ArrayList<TreeNode>();
        level_nodes.add(root);
        boolean left_to_right = true;
        
        while(level_nodes.size() > 0) {
            ArrayList<TreeNode> curr_level_nodes = new ArrayList<TreeNode>();
            ArrayList<Integer> curr_level_vals = new ArrayList<Integer>();
            int size = level_nodes.size();
            for(int i = 0; i < size; i++) {
                if(left_to_right) {
                    curr_level_vals.add(level_nodes.get(i).val);
                }
                else {
                    curr_level_vals.add(level_nodes.get(size - 1 - i).val);
                }
                if(level_nodes.get(i).left !=  null) {
                    curr_level_nodes.add(level_nodes.get(i).left);
                }
                if(level_nodes.get(i).right !=  null) {
                    curr_level_nodes.add(level_nodes.get(i).right);
                }
            }
            left_to_right = !left_to_right;
            ret.add(curr_level_vals);
            level_nodes = curr_level_nodes;
        }
        return ret;
    }
}
