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
        TreeNode(int x) { 
            val = x; 
        }
    }

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack =  new Stack<TreeNode>();
        HashMap<TreeNode, Boolean> visited = new HashMap<TreeNode, Boolean>();
        if(root ==  null) {
            return ret;
        }
        stack.push(root);
        while(stack.empty() == false) {
            TreeNode curr_top = stack.peek();
            if(curr_top.left == null) {
                ret.add(curr_top.val);
                stack.pop();
                if(curr_top.right != null) {
                    stack.push(curr_top.right);
                }
            }
            else {
                if(visited.containsKey(curr_top)) {
                    ret.add(curr_top.val);
                    stack.pop();
                    if(curr_top.right != null) {
                        stack.push(curr_top.right);
                    }
                }
                else {
                    stack.push(curr_top.left);
                    visited.put(curr_top, true);
                }
            }
        }
        return ret;
    }
    
    public ArrayList<Integer> inorderTraversal_recursive(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }
        if(root.left != null) {
            ret = inorderTraversal(root.left);
        }
        ret.add(root.val);
        if(root.right != null) {
            ArrayList<Integer> ret_r =  inorderTraversal(root.right);
            for(int curr: ret_r) {
                ret.add(curr);
            }
        }
        return ret;
        
    }
}
