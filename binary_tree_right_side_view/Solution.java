/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }
        ArrayList<TreeNode> curr_level_nodes = new ArrayList<TreeNode>();
        curr_level_nodes.add(root);
        while(curr_level_nodes.size() > 0) {
            ret.add(curr_level_nodes.get(curr_level_nodes.size()-1).val);
            ArrayList<TreeNode> next_level_nodes = new ArrayList<TreeNode>();
            for(int i = 0; i < curr_level_nodes.size(); i++) {
                if(curr_level_nodes.get(i).left !=  null) {
                    next_level_nodes.add(curr_level_nodes.get(i).left);
                }
                if(curr_level_nodes.get(i).right !=  null) {
                    next_level_nodes.add(curr_level_nodes.get(i).right);
                }
            }
            curr_level_nodes =  next_level_nodes;
        }
        return ret;
    }
}
