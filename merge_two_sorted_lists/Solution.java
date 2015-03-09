public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode before_newHead = new ListNode(0);
        ListNode currNode = before_newHead;
        while(l1 !=  null && l2 != null) {
            if(l1.val <= l2.val) {
                currNode.next = l1;
                l1 = l1.next;
            }
            else {
                currNode.next = l2;
                l2 = l2.next;
            }
            currNode = currNode.next;
        }
        if (l1 == null) {
            currNode.next = l2;
        }
        else {
            currNode.next = l1;
        }
        return before_newHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
