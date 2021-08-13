package LC21MergeTwoSortedLists;

// Approach 1
// Complexity: 
// Runtime: O(m+n)
// Space: O(m+n)
//class Solution {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        ListNode dummy = new ListNode(0);
//        ListNode head = dummy;
//        ListNode curr1 = l1, curr2 = l2;
//        while(curr1 != null && curr2 != null) {
//            if (curr1.val <= curr2.val) {
//                head.next = curr1;
//                curr1 = curr1.next;
//            } else {
//                head.next = curr2;
//                curr2 = curr2.next;
//            }
//            head = head.next;
//            // curr1 = curr1.next;
//            // curr2 = curr2.next;
//        }
//        if (curr1 == null && curr2 == null){
//            return dummy.next;
//        }
//        if (curr1 == null) {
//            head.next = curr2;
//        } else {
//            head.next = curr1;
//        }
//        return dummy.next;
//    }
//}

// Approach Recursion
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}