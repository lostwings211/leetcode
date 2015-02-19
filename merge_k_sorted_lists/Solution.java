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
import java.util.Comparator;
import java.util.PriorityQueue;
public class Solution {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
                        public int compare(ListNode a, ListNode b) {
                            if (a.val > b.val)
                                return 1;
                            else if(a.val == b.val)
                                return 0;
                            else 
                                return -1;
                        }
                    });
        ListNode top =  new ListNode(0);
        ListNode ret = top;
        for(int i = 0; i < lists.size(); i++) {
            if(lists.get(i) !=  null) {
                queue.add(lists.get(i));
            }    
        }
        
        while(queue.size() != 0) {
            ListNode currSmallest = queue.poll();
            ret.next = currSmallest;
            if(currSmallest.next != null) {
                queue.add(currSmallest.next);
            }
            ret = ret.next;
        }
        return top.next;
    }
}
