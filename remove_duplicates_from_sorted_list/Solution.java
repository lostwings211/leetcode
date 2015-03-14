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
        ListNode curr = head;
        while(curr != null) {
            ListNode nodup = curr;
            while(nodup.next !=  null && nodup.val == nodup.next.val) {
                nodup = nodup.next;
            }
            curr.next = nodup.next;
            curr =  nodup.next;
        }
        return head;
    }
}
