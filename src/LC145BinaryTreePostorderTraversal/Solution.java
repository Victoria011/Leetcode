package LC145BinaryTreePostorderTraversal;

import template.TreeNode;
import java.util.*;

public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
                //visit left first
            } else {
                TreeNode node = stack.peek().right; // left has done, check whether we have right side unvisited
                if (node == null) { //right side is null, no need to visit, so pop out the node, we can add to list
                    node = stack.pop();
                    list.add(node.val);
                    while (!stack.isEmpty() && stack.peek().right == node) {
                        node = stack.pop();
                        list.add(node.val); // right side has done
                    }
                } else {
                    cur = node;//deal with right side
                }
            }
        }
        return list;
    }
}