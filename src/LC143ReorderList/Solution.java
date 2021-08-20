package LC143ReorderList;
import template.ListNode;

public class Solution {
	public ListNode reverseList(ListNode head) { // changed the original list - not okay
        if (head == null) return head;
        ListNode reversedList = new ListNode(); // null curr!=null or 0 curr.next!=null来使用
        ListNode curr = head;
        while (curr != null) {
            ListNode newNode = new ListNode(curr.val);
            newNode.next = reversedList;
            reversedList = newNode;
            curr = curr.next;
        }
        return reversedList;
    }
    
    public int getLength(ListNode head){
        int len = 0;
        ListNode curr = head;
        while(curr != null){
            curr = curr.next;
            ++len;
        }
        return len;
    }
    
//    public void reorderList(ListNode head) {
//        if (head == null) return;
//        int len = getLength(head);
//        System.out.println("Length = "+Integer.toString(len));
//        System.out.println("Length = "+Integer.toString(len/2));
//        ListNode reversedList = reverseList(head);
//        ListNode dummyHead = new ListNode(0);
//        ListNode curr = dummyHead;
//        
//        ListNode pt1 = head;
//        ListNode pt2 = reversedList;
//        for (int i=0; i<(len/2); i++){
//            curr.next = new ListNode(pt1.val);
//            pt1 = pt1.next;
//            curr.next.next = new ListNode(pt2.val);
//            pt2 = pt2.next;
//            curr = curr.next.next;
//        }
//        // if len odd, add pt1
//        if ( len % 2 == 1 ) curr.next = new ListNode(pt1.val);
//        head = dummyHead.next;
//        System.out.println("dummyHead: ");
//        dummyHead.printLinkedList(dummyHead.next);
//    }
    
    public void reorderList(ListNode head) {
    	if (head == null) return;
    	int len = getLength(head);
    	ListNode reversedList = reverseList(head);
    	ListNode curr = new ListNode();
    	ListNode pt1 = head;
    	ListNode pt2 = reversedList;
    	for (int i=0; i<(len/2); i++){
    		curr.next = pt1;
    		ListNode tmp = pt1.next;
    		ListNode tmp2 = pt2.next;
    		pt1 = tmp;
    		curr.next.next = pt2;
    		curr = pt2;
    		pt2 = tmp2;
    	}
    	if ( len % 2 == 1 ) {
    		curr.next = pt1;
    		curr = curr.next;
    	}
    	curr.next = null;
    }
}

