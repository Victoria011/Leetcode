// 模版 
package template;

public class LinkedList {
	LinkedList linkedlist;
	LinkedList () {}
//	LinkedList (int[] intArray) {
//		ListNode
//		for (int i=0; i<intArray.length; i++) {
//			
//		}
//	}
	// create linkedlist
	public ListNode createLinkedList() {
		ListNode tmp1 = new ListNode(5);
		ListNode tmp2 = new ListNode(8);
		ListNode tmp3 = new ListNode(2);
		tmp1.next = tmp2;
		tmp2.next = tmp3;
		tmp3.next = null;
		return tmp1;
	}
	// find linked list length 
	public int getLength(ListNode l1) {
		int n1 = 0;
        ListNode curr1 = l1;
        while (curr1 != null) {
            curr1 = curr1.next; 
            ++n1;    
        }
        return n1;
	}
	// reverse LinkedList
	public ListNode reverseLinkedList(ListNode head) {
		ListNode last = null;
		while(head != null) {
			ListNode tmp = head.next;
			head.next = last;
			last = head;
			head = tmp;
		}
		return last;
	} 
	
	public void printLinkedList(ListNode head) {
		System.out.println("---- LinkedList: ");
		String msg = "";
		while (head != null) {
			msg += Integer.toString(head.val);
			if (head.next != null) {
				msg += " -> ";
			}
			head = head.next;
		}
		System.out.println(msg);
	}
	
//	public String toString(ListNode head) {
//		String result = "";
//        ListNode current = head;
//        while(head.next != null){
//            result += current.val;
//            if(current.next != null){
//                 result += ", ";
//            }
//            current = current.next;
//        }
//        return "List: " + result;
//	}
}


//LinkedList list = new LinkedList();
//list.insertFront(1);
//list.insertFront(2);
//list.insertFront(3);
//System.out.println(list.toString());


// MergeSort LinkedList LC 148