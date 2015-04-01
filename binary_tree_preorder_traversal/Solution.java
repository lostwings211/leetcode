import java.util.*;
public class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root != null) {
            stack.push(root);
        }
        
        while(!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            ret.add(curr.val);
            if(curr.right !=  null) {
                stack.push(curr.right);
            }
            if(curr.left !=  null) {
                stack.push(curr.left);
            }
        }
        return ret;
    }
    
    public ArrayList<Integer> preorderTraversal_recursive(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }
        ret.add(root.val);
        for(Integer left : preorderTraversal(root.left)) {
            ret.add(left);
        }
        for(Integer right : preorderTraversal(root.right)) {
            ret.add(right);
        }
        return ret;
    }
}
