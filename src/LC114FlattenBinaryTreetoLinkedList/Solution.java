package LC114FlattenBinaryTreetoLinkedList;

import template.TreeNode;

// Approach 1: Recursion
public class Solution {
    public TreeNode flattenTree(TreeNode root) {
        // base case
        if (root == null || (root.left == null && root.right == null)) return root;
        
        // left subtree root.left
        TreeNode leftTail = flattenTree(root.left);
        // right subtree root.right
        TreeNode rightTail = flattenTree(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        // We need to return the "rightmost" node after we are
        // done wiring the new connections. 
        return rightTail == null ? leftTail : rightTail;
    }
    
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
}