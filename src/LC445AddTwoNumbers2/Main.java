package LC445AddTwoNumbers2;

//包含主函数（控制逻辑、测试用例数组）、测试函数（测试结果输出、算法耗时）
// 主要有几个函数
//main主函数：写输入输出，调用解决函数
//解决函数：需要LeetCode提交，直接复制这个函数即可
//其他函数：在解决函数中所用到的函数，eg：求链表长度函数

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// Testcase
//	private static void test(int input) {
//		Solution solution = new Solution();
//	}

}


//my solution
//public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//    // start adding from the end, create new ListNode with prev pointer
//    ListNode dummyHead = new ListNode(0);
//    ListNode new1, new2, curr = new ListNode(-1), new ListNode(-1), dummyHead;
//    // pointers
//    ListNode p1, p2 = l1, l2;
//    ListNode newp1, newp2 = new1, new2;
//    // ListNode;
//    int carry = 0;
//    //getting reverse linked list
//    while(p1 != null || p2 != null){
//        int val1 = (p1 != null) ? p1.val : -1;
//        int val2 = (p2 != null) ? p2.val : -1;
//        ListNode curr1 = new ListNode(val1);
//        ListNode curr2 = new ListNode(val2);
//        curr1.next = new1;
//        curr2.next = new2;
//        new1 = curr1;
//        new2 = curr2;
//        if (p1 != null) p1 = p1.next;
//        if (p2 != null) p2 = p2.next;
//    }
//    // new1, new2 start with val = -1
//    p1 = new1, p2 = new2;
//    while(p1 != null || p2 != null){
//        while (p1 != null && p1.val == -1){
//            p1 = p1.next;
//        }
//        while (p2 != null && p2.val == -1){
//            p2 = p2.next;
//        }
//        int val1 = (p1 != null) ? p1.val : 0;
//        int val2 = (p2 != null) ? p2.val : 0;
//        int sum = val1 + val2 + carry;
//        carry = sum / 10;
//        curr.next = new ListNode(sum % 10);
//        curr = curr.next;
//        if (p1 != null) p1 = p1.next;
//        if (p2 != null) p2 = p2.next;
//    }
//    // reverse answer
//    curr = dummyHead;
//    ListNode newD = new ListNode(0);
//    while (curr != null) {
//        newD.next = curr;
//        curr = curr.next;
//    }
//    return newD;
//}
