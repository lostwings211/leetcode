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
    public TreeNode str2tree(String s) {
        if(s.length() == 0) {
            return null;
        }
        int node_val = 0;
        int i = 0;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                break;
            }
            i++;
        }
        node_val = Integer.parseInt(s.substring(0, i));
        TreeNode root = new TreeNode(node_val);
        if(i == s.length()) {
            return root;
        }
        
        ArrayList<Integer> stack = new ArrayList<Integer>();
        int start = i;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                stack.add(0);
            }
            else if(s.charAt(i) == ')') {
                if(stack.size() > 0) {
                    stack.remove(stack.size() - 1);
                }
            }
            if(stack.size() == 0) {
                break;
            }
            i++;
        }
        String left_tree = s.substring(start + 1, i);
        
        if(i == s.length() - 1) {
            root.left =  str2tree(left_tree);
            return root;
        }
        
        stack = new ArrayList<Integer>();
        i =  i + 1;
        start = i;
        while(i < s.length()) {
            if(s.charAt(i) == '(') {
                stack.add(0);
            }
            else if(s.charAt(i) == ')') {
                if(stack.size() > 0) {
                    stack.remove(stack.size() - 1);
                }
            }
            if(stack.size() == 0) {
                break;
            }
            i++;
        }
        String right_tree = s.substring(start + 1, i);
        root.left =  str2tree(left_tree);
        root.right =  str2tree(right_tree);
        return root;
    }
}
