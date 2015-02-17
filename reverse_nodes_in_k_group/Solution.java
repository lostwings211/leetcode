public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode top =  new ListNode(0);
        top.next = head;
        ListNode prev = top;
        ListNode curr = head;
        ListNode last = getKthNode(head, k);
        while (curr != null & last !=null) {
            ListNode temp = last.next;
            swapNodes(curr, last);
            
            prev.next = last;
            curr.next = temp;
            prev =  curr;
            curr = temp;
            last = getKthNode(curr, k);
        }
        return top.next;
    }
    
    public void swapNodes(ListNode head, ListNode tail) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr !=  tail) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        tail.next = prev;
    }
    
    public ListNode getKthNode(ListNode head, int k) {
        int count = 1;
        ListNode curr = head;
        while(count < k) {
            if(curr != null) {
                curr = curr.next;
            }
            else {
                break;
            }
            count++;
        }
        return curr;
    }
}
