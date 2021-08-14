package template;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode (int x) {
		val = x;
		next = null;
	}
	//定义输出函数
	public String show() {
		return this.val + "->" + (this.next == null ? "null" : this.next.show());
	}
	
	public int getLinkedListLength(ListNode head) {
		int len = 0;
		ListNode curr = head;
		while(curr != null) {
			curr = curr.next;
			++len;
		}
		return len;
	}
	
	public void printLinkedList(ListNode head) {
		System.out.println("---LinkedList: ");
		if (head == null) {
			System.out.println("[]");
		}
		ListNode curr = head;
		String string = "";
		while(curr != null) {
			string += Integer.toString(curr.val);
			if (curr.next != null) {
				string += " -> ";
			}
			curr = curr.next;
		}
		System.out.println(string);
	}
	
	public ListNode createLinkedList(int[] list) {
		ListNode head = new ListNode(0);
		ListNode curr = head;
		for (int num : list) {
			System.out.println(Integer.toString(num));
			ListNode tmp = new ListNode(num);
			curr.next = tmp;
			curr = curr.next;
		}
		return head.next;
	}
}
