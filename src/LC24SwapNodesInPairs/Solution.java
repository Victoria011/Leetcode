package LC24SwapNodesInPairs;

//recursion
// Complexity 
// Runtime: O(N)
// Space O(N)
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

//Iteration
//Complexity 
//Runtime: O(N)
//Space O(1)
//class Solution {
// public ListNode swapPairs(ListNode head) {
//     ListNode dummy = new ListNode(-1);
//     dummy.next = head;
//     
//     ListNode prevNode = dummy;
//     
//     while ((head != null) && (head.next != null)) {
//         ListNode firstNode = head;
//         ListNode secondNode = head.next;
//         
//         prevNode.next = secondNode;
//         firstNode.next = secondNode.next;
//         secondNode.next = firstNode;
//         
//         prevNode = firstNode;
//         head = firstNode.next;
//     }
//     
//     return dummy.next;
// }
//}
