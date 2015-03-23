import java.util.*;
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(root == null) {
            return ret;
        }
        ArrayList<TreeNode> level_nodes = new ArrayList<TreeNode>();
        level_nodes.add(root);
        
        while(level_nodes.size() > 0) {
            ArrayList<Integer> curr_list = new ArrayList<Integer>();
            ArrayList<TreeNode> curr_level_nodes =  new ArrayList<TreeNode>();
            for(int i = 0; i < level_nodes.size(); i++) {
                curr_list.add(level_nodes.get(i).val);
                if(level_nodes.get(i).left != null) {
                    curr_level_nodes.add(level_nodes.get(i).left);
                }
                if(level_nodes.get(i).right != null) {
                    curr_level_nodes.add(level_nodes.get(i).right);
                }
            }
            ret.add(curr_list);
            level_nodes = curr_level_nodes;
        }
        return change_order(ret);
    }
    
    public ArrayList<ArrayList<Integer>> change_order(ArrayList<ArrayList<Integer>> input) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        for(int i = input.size() - 1; i >= 0; i--) {
            ret.add(input.get(i));
        }
        return ret;
    }
}
