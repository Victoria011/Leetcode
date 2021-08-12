package LC445AddTwoNumbers2;

//算法类，注意到 LeetCode 每道题目的代码类名为 Solution
public class Solution {
	public ListNode reverseList(ListNode head) {
        ListNode last = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = last;
            last = head;
            head = tmp;
        }
        return last;
        
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // reverse list
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        
        ListNode head = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // get the curr values
            int x1 = l1 != null ? l1.val: 0;
            int x2 = l2 != null ? l2.val : 0;
            
            // curr sum and carry
            int val = (carry + x1 + x2) % 10;
            carry = (carry + x1 + x2) / 10;
            
            // update result: add to front
            ListNode curr = new ListNode(val);
            curr.next = head;
            head = curr;
            
            // move to the next elements in the lists
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        
        if (carry != 0) {
            ListNode curr = new ListNode(carry);
            curr.next = head;
            head = curr;
        }
        return head;
        
    }
}
