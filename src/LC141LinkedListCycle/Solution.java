package LC141LinkedListCycle;
import java.util.HashSet;
import java.util.Set;

import template.ListNode;

// Approach 1: Hash table storing reference / memory address
//Runtime O(N)
//Space: O(N)

//public class Solution {
// public boolean hasCycle(ListNode head) {
//     Set<ListNode> nodesSeen = new HashSet<>();
//     while(head != null) {
//         if (nodesSeen.contains(head)){
//             return true;
//         }
//         nodesSeen.add(head);
//         head = head.next;
//     }
//     return false;
// }
//}

//two pointers fast slow if they meet then has cycle
//exceed timelimit
//Approach 2: Floyd's Cycle Finding Algorithm
public class Solution {
 public boolean hasCycle(ListNode head) {
     if (head == null) return false;
     ListNode fast = head.next;
     ListNode slow = head;
     
     while (slow != fast){
         if (fast == null || fast.next == null) return false; // has an end
         fast = fast.next.next;
         slow = slow.next;
     }
     return true;
 }
}