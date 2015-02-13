/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if( n <= 0 || head == null) {
            return head;
        }

        List<ListNode> map = new ArrayList<ListNode>();
        ListNode curr = head;
        int count = 0;
        while(curr != null) {      
            map.add(curr);
            count++;
            curr = curr.next;
        }
        
        if(n>count) {
            return head;
        }
        else if (n==count) {
           if(count==1) { 
                return null;
            }
            else {
                return map.get(1);
            }
        }
        ListNode ret  = map.get(count - n - 1);
        ret.next = ret.next.next;
        return map.get(0);
    }
}
