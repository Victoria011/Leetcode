package LC24SwapNodesInPairs;

//recursion
class Solution {
 public ListNode swapPairs(ListNode head) {
     if (head == null || head.next == null) return head;
     ListNode tmp = head;
     ListNode rest = head.next.next;
     head = head.next;
     head.next = tmp;
     tmp.next = swapPairs(rest); // if directly head.next.next -- infinite loop why?
     return head;
 }
}
