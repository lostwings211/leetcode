import java.util.*;
public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { 
            val = x; next = null; 
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { 
            val = x; 
        }
    }

    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> nums_array = new ArrayList<Integer>();
        while(head != null) {
            nums_array.add(head.val);
            head = head.next;
        }
        Integer nums[] =  new Integer[nums_array.size()];
        nums = nums_array.toArray(nums);
        return sortedArrayToBST(nums);
    }
    
    public TreeNode sortedArrayToBST(Integer[] num) {
        if(num ==  null || num.length == 0) {
            return null;
        }
        if(num.length == 1) {
            return new TreeNode(num[0]);
        }
        int half = num.length / 2;
        TreeNode root = new TreeNode(num[half]);
        Integer num_left[] =  new Integer[half];
        Integer num_right[] = new Integer[num.length - half - 1];
        System.arraycopy(num, 0, num_left, 0, half);
        System.arraycopy(num, half + 1, num_right, 0, num.length - half - 1);
        root.left = sortedArrayToBST(num_left);
        root.right = sortedArrayToBST(num_right);
        return root;
    }
}
