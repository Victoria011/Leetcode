package LC445AddTwoNumbers2;

// Approach 1
// Complexity 
// Runtime: O(N1 + N2) N1, N2 length of lists
// Space:   O(1) not taking result into account; O(max(N1, N2)) - storing output list
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

// Follow up - do not reverse
// Approach 2: 
// 将对应位置digit相加 暂时先不考虑carry 比如加起来是10 就存10 
// 然后再将carry加给前面一个数字
// 最后reverse output
// Complexity:
// Runtime: O(N1 + N2)
// Space: O(1), O(max(N1, N2))


//Approach 2
//class Solution {
// public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//     // 1. find length of both lists
//     int n1 = 0, n2 = 0;
//     ListNode curr1 = l1, curr2 = l2;
//     while(curr1 != null){
//         curr1 = curr1.next;
//         ++n1;
//     }
//     while (curr2 != null) {
//         curr2 = curr2.next; 
//         ++n2;    
//     }
//     
//     // parse both lists
//     curr1 = l1;
//     curr2 = l2;
//     ListNode head = null;
//     while (n1 > 0 && n2 > 0) {
//         int val = 0;
//         if (n1 >= n2) {
//             val += curr1.val;
//             curr1 = curr1.next;
//             --n1;
//         }
//         if (n1 < n2) {
//             val += curr2.val;
//             curr2 = curr2.next;
//             --n2;
//         }
//         
//         ListNode curr = new ListNode(val);
//         curr.next = head;
//         head = curr;
//     }
//     
//     curr1 = head;
//     head = null;
//     int carry = 0;
//     while (curr1 != null) {
//         int val = (curr1.val + carry) % 10;
//         carry = (curr1.val + carry) / 10;
//         
//         ListNode curr = new ListNode(val);
//         curr.next = head;
//         head = curr;
//         
//         curr1 = curr1.next;
//     }
//     
//     if (carry != 0) {
//         ListNode curr = new ListNode(carry);
//         curr.next = head;
//         head = curr;
//     }
//     
//     return head;
// }
//}
