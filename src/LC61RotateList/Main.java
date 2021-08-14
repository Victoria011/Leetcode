package LC61RotateList;

import template.ListNode;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		ListNode head = new ListNode(0);
		int[] numbers = {1,2,3};
		head = head.createLinkedList(numbers);
		head.printLinkedList(head);
		ListNode result = solution.rotateRight(head, 0);
		head.printLinkedList(result);
	}

}
