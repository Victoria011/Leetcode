package LC111MinimumDepthofBinaryTree;

import template.TreeNode;

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if ((root.left == null) && (root.right == null)) return 1;
        if ((root.left == null) || (root.right == null)) {
            if (root.left == null) {
                return minDepth(root.right) + 1;
            } else {
                return minDepth(root.left) + 1;
            }
        }
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}