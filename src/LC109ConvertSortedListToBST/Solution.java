package LC109ConvertSortedListToBST;

import template.TreeNode;
import template.ListNode;

// Recursion
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        // base case 
        if (head == null) return null;
        if (head.next == null) {
            TreeNode dummy = new TreeNode(head.val);
            return dummy;
        }
        
        //get length
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            ++len;
        } 
        
        //get root
        int idx = len / 2;
        curr = head;
        for (int i = 0; i < idx-1; i++){
            curr = curr.next;
        }
        ListNode mid = curr.next;
        TreeNode rightside = sortedListToBST(mid.next);
        curr.next = null;
        TreeNode leftside = sortedListToBST(head);
        TreeNode root = new TreeNode(mid.val, leftside, rightside);
        // TreeNode root.left = head;
        // recursively decide left right sub tree
        return root;
    }
}