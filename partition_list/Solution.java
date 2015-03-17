public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode partition(ListNode head, int x) {
        ListNode pre_head_small = new ListNode(0);
        pre_head_small.next = null;
        ListNode pre_head_big = new ListNode(0);
        pre_head_big.next = null;
        
        ListNode pre_head_small_curr = pre_head_small;
        ListNode pre_head_big_curr = pre_head_big;
        
        while(head !=  null) {
            ListNode next = head.next;
            head.next =  null;
            if(head.val < x) {
                pre_head_small_curr.next = head;
                pre_head_small_curr =  head;
            }
            else {
                pre_head_big_curr.next = head;
                pre_head_big_curr = head;
            }
            head = next;
        }
        
        if(pre_head_small.next != null) {
            pre_head_small_curr.next = pre_head_big.next;
            return pre_head_small.next;
        }
        return pre_head_big.next;
    }
}
