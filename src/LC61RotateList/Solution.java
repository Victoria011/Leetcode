package LC61RotateList;

import template.ListNode;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // get length
        int len = 0;
        ListNode curr = head;
        if (head == null || k == 0) {
        	System.out.println("Empty list");
        	return head;
        }
        while(curr.next != null) {
            curr = curr.next;
            len++;
        }
        if(curr != null){
            len++;
        }
        System.out.println("List length = "+Integer.toString(len));
        if ( len == 1){
            return head;
        }
        
        ListNode tail = curr;
        // keep tail
        int idx = k % len;
        if (idx == 0) return head;
        // find idxth element
        int i=0;
        curr = head;
        while(i< len-idx-1){
            curr = curr.next;
            i++;
        }
        ListNode tmp = curr.next;
        curr.next = null;
        tail.next = head;
        return tmp;
    }

    public void printList(ListNode head) {
    	System.out.println("--- LinkedList:");
    	ListNode curr = head;
    	if (head == null) {
    		System.out.println("[]");
    	}
    	String string = "List: ";
    	while(curr != null) {
    		string += Integer.toString(curr.val);
    		if (curr.next != null) {
    			string += ", ";
    		}
    		curr = curr.next;
    	}
    	System.out.println(string);
    }    
}

// Considering boundary 0 case, k could be 0, list could be empty, idx could be 0
