public class Solution {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        root.next = null;
        TreeLinkNode prev_fix =  root;
        TreeLinkNode curr_fix = root.left;
        TreeLinkNode prev = prev_fix;
        TreeLinkNode curr = curr_fix;
        boolean is_leftchild = true;
        while(curr !=  null) {
            if(is_leftchild) {
               curr.next = prev.right;
            }
            else {
               prev = prev.next;
               if(prev == null) {
                   curr.next = null;
               }
               else {
                   curr.next = prev.left;
               }
            }
           
            if(curr.next !=  null) {
               curr = curr.next;
               is_leftchild = !is_leftchild;
            }
            else {
               curr = curr_fix.left;
               prev = prev_fix.left;
               curr_fix =  curr;
               prev_fix =  prev;
               is_leftchild = true;
            }
        }
    }
}
