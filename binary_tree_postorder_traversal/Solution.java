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

    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        HashMap<TreeNode, Boolean> visit = new HashMap<TreeNode, Boolean>();
        if(root != null) {
            stack.push(root);
        }
        while(!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if(visit.containsKey(curr)) {
                ret.add(curr.val);
                stack.pop();
            }
            else {
                visit.put(curr, true);
                if(curr.right !=  null) {
                    stack.push(curr.right);
                }
                if(curr.left !=  null) {
                    stack.push(curr.left);
                }
            }
        }
        return ret;
    }
    
    public ArrayList<Integer> postorderTraversal_recursive(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(root == null) {
            return ret;
        }
        
        for(Integer left : postorderTraversal(root.left)) {
            ret.add(left);
        }
        for(Integer right : postorderTraversal(root.right)) {
            ret.add(right);
        }
        ret.add(root.val);
        return ret;
    }
}
