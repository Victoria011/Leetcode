package LC143ReorderList;
import template.ListNode;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		
		// test case
		int[] testcase1 = {1,2,3,4};
		ListNode testcaseList = new ListNode();
		testcaseList = testcaseList.createLinkedList(testcase1);
		System.out.println("---Original: ");
		testcaseList.printLinkedList(testcaseList);
		
		ListNode reversed1 = solution.reverseList(testcaseList);
		System.out.println("---Reverse: ");
		testcaseList.printLinkedList(reversed1);
		
		int len = solution.getLength(testcaseList);
		System.out.println("length: "+Integer.toString(len));
		
		System.out.println("---Reorder: ");
		solution.reorderList(testcaseList);
		testcaseList.printLinkedList(testcaseList);
		
	}

}
