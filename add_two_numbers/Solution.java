public class Solution {
	
	public class ListNode {
		int val;
		ListNode next;
		ListNode (int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode current = null;
		ListNode previous = null;
		ListNode header =  null;
		int remainder = 0;
		while (l1 != null || l2 != null || remainder > 0) {
			int curr_l1 = (l1 != null) ? l1.val : 0;
			int curr_l2 = (l2 != null) ? l2.val : 0;
			
			int sum =  curr_l1 + curr_l2 + remainder;
			if (sum  >=  10 ) {
				sum =  sum - 10;
				remainder = 1;
			}
			else {
				remainder = 0;
			}
			
			current = new ListNode(sum);
			if (previous != null) {
				previous.next = current;
			}
			else {
				header = current;
			}
			previous = current;
			l1 =  (l1 == null) ? l1: l1.next;
			l2 =  (l2 == null) ? l2: l2.next; 
		}
		return header;
	}
}
