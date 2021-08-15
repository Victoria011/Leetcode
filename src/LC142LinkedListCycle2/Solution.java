package LC142LinkedListCycle2;
import template.ListNode;
//可以用hashset做 但如果想 O(1)必须用指针
//HashSet Runtime O (N) Space O (N)
//public class Solution {
//  public ListNode detectCycle(ListNode head) {
//      Set<ListNode> visited = new HashSet<ListNode>();
     
//      ListNode node = head;
//      while(node != null) {
//          if (visited.contains(node)){ // 第一个重复的肯定是起点
//              return node;
//          }
//          visited.add(node);
//          node = node.next;
//      }
//      return null;
//  }
//}

//Approach 2 Floyd's Tortoise and Hare
//分成两步 第一步确认有cycle, 
//public class Solution {
//  public ListNode detectCycle(ListNode head) {
     
//  }
//}
public class Solution {
	ListNode detectCycle(ListNode head) {
	    if (head == null || head.next == null) return null;
	
		ListNode firstp = head;
		ListNode secondp = head;
		Boolean isCycle = false;
		
		while(firstp != null && secondp != null) {
		    firstp = firstp.next;
		    if (secondp.next == null) return null;
		    secondp = secondp.next.next;
		    if (firstp == secondp) { isCycle = true; break; }
		}
		
		if(!isCycle) return null;
		firstp = head;
		while( firstp != secondp) {
		    firstp = firstp.next;
		    secondp = secondp.next;
		}
		return firstp;
	}
}
