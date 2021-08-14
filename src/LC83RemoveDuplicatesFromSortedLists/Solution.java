package LC83RemoveDuplicatesFromSortedLists;

import template.ListNode;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null || head.next == null) return head;
        
        ListNode curr = head.next;
        ListNode prev = head;
        while(curr != null) {
            if (prev.val == curr.val) {
                ListNode tmp = curr.next;
                curr.next = null;
                prev.next = tmp;
                curr = tmp;
            } else {
                curr = curr.next;
                prev = prev.next;
            }
        }
        return head;
    }
}

//Approach 2: recursion
//class Solution {
// public ListNode deleteDuplicates(ListNode head) {
//     if (head == null || head.next == null) return head;
//     if (head.val == head.next.val) {
//         head = deleteDuplicates(head.next);
//     } else {
//         head.next = deleteDuplicates(head.next);
//     }
//     return head;
// }
//}