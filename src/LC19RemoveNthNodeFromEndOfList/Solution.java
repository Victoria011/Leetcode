package LC19RemoveNthNodeFromEndOfList;

//Approach 1 Two pass alg
class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
	     // get length 
	     ListNode curr = head;
	     int len = 0;
	     while(curr != null) {
	         curr = curr.next;
	         ++len;
	     }
	     
	     //find nth
	     int i = 0;
	     curr = head;
	     if (n >= len) { // remove head
	         return head.next;
	     }
	     while(i < len - n-1){
	         curr = curr.next;
	         i++;
	     }
	     // if curr.next == null ;
	     if (curr.next.next == null) { // remove last
	         curr.next = null;
	         return head;
	     }
	         
	     
	     ListNode tmp = curr.next.next;
	     curr.next.next = null;
	     curr.next = tmp;
	     return head;
	 }
}
