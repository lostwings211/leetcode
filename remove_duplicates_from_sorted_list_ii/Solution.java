public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pre_head = new ListNode(0);
        pre_head.next = head;
        ListNode pre_curr = pre_head;
        ListNode curr = head;
        while(curr !=  null) {
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            // the curr Node is a duplicate, those nodes need to be removed from the list
            if(pre_curr.next !=  curr) {
                pre_curr.next = curr.next;
            }
            else {
                pre_curr = curr;
            }
            curr = curr.next;
        }
        return pre_head.next;
    }
}
