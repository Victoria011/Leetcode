package LC86PartitionList;
import template.ListNode;

//Official Solution : use two list store less and greater
public class Solution {
    public ListNode partition(ListNode head, int x) {
        // base case
        if (head == null || head.next == null) return head;
        
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;
        
        while(head != null) {
            if (head.val < x){
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        
        after.next = null;
        
        before.next = after_head.next;
        
        return before_head.next;
        
    }
}

