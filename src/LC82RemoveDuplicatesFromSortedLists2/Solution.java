package LC82RemoveDuplicatesFromSortedLists2;

import template.ListNode;
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // base case
        if (head == null || head.next == null) return head;
        
        ListNode prev = new ListNode(0);
        prev.next = head;
        ListNode curr = head;
        head = prev;
        ListNode after = curr.next;
        while(after != null){
            if (curr.val == after.val){
                while((after.next != null) && (curr.val == after.val)){
                    after = after.next;
                }
                if ((after.next == null) && (curr.val == after.val)){
                    prev.next = null;
                    return head.next;
                }
                prev.next = after;
                curr = after;
                after = after.next;
            } else {
                curr = curr.next;
                after = after.next;
                prev = prev.next;
            }
        }
        return head.next;
    }
}

// Official Solution 
// Sentinel Head + Predecessor
//class Solution {
//    public ListNode deleteDuplicates(ListNode head) {
//        // sentinel
//        ListNode sentinel = new ListNode(0, head);
//
//        // predecessor = the last node 
//        // before the sublist of duplicates
//        ListNode pred = sentinel;
//        
//        while (head != null) {
//            // if it's a beginning of duplicates sublist 
//            // skip all duplicates
//            if (head.next != null && head.val == head.next.val) {
//                // move till the end of duplicates sublist
//                while (head.next != null && head.val == head.next.val) {
//                    head = head.next;    
//                }
//                // skip all duplicates
//                pred.next = head.next;     
//            // otherwise, move predecessor
//            } else {
//                pred = pred.next;    
//            }
//                
//            // move forward
//            head = head.next;    
//        }  
//        return sentinel.next;
//    }
//}