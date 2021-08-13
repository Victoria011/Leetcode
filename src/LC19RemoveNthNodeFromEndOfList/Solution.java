package LC19RemoveNthNodeFromEndOfList;

// Approach 1 Two pass alg
// Complexity
// Runtime O(n)
// Space O(1)

//class Solution {
//	public ListNode removeNthFromEnd(ListNode head, int n) {
//	     // get length 
//	     ListNode curr = head;
//	     int len = 0;
//	     while(curr != null) {
//	         curr = curr.next;
//	         ++len;
//	     }
//	     
//	     //find nth
//	     int i = 0;
//	     curr = head;
//	     if (n >= len) { // remove head
//	         return head.next;
//	     }
//	     while(i < len - n-1){
//	         curr = curr.next;
//	         i++;
//	     }
//	     // if curr.next == null ;
//	     if (curr.next.next == null) { // remove last
//	         curr.next = null;
//	         return head;
//	     }
//	         
//	     ListNode tmp = curr.next.next;
//	     curr.next.next = null;
//	     curr.next = tmp;
//	     return head;
//	 }
//}

// Approach 2 One pass alg
// Complexity
// Runtime: O(n)
// Space: O(1)
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode first = dummy;
      ListNode second = dummy;
      
      for (int i = 1; i <= n+1; i++) {
          first = first.next;
      }
      
      while (first != null) {
          first = first.next;
          second = second.next;
      }
      second.next = second.next.next;
      return dummy.next;
  }
}

