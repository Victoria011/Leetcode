package template;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList list = new LinkedList();
		ListNode l1 = list.createLinkedList();
		list.printLinkedList(l1);
		ListNode l2 = list.reverseLinkedList(l1);
		list.printLinkedList(l2);
	}

}
