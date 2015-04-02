public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre_head = new ListNode(0);
        pre_head.next = head;
        ListNode curr_pre = head;
        
        while(curr_pre.next !=  null) {
            ListNode curr =  curr_pre.next;
            ListNode sorted_pre = pre_head;
            
            while(sorted_pre.next.val <= curr.val && sorted_pre.next !=  curr) {
                sorted_pre = sorted_pre.next;
            }
            
            if(sorted_pre.next.val  > curr.val) {
                curr_pre.next = curr.next;
                curr.next = sorted_pre.next;
                sorted_pre.next = curr;
            }
            else {
                curr_pre = curr;
            }
        }
        return pre_head.next;
    }
}
