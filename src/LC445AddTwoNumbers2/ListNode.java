package LC445AddTwoNumbers2;

public class ListNode {
	int val;
	ListNode next;
	ListNode (int x) {
		val = x;
		next = null;
	}
	//定义输出函数
	public String show() {
		return this.val + "->" + (this.next == null ? "null" : this.next.show());
	}
}
// delete random msg ??