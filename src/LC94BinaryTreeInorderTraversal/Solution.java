package LC94BinaryTreeInorderTraversal;

import template.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;


//Approach 1: Recursive
//public class Solution {
//    private void helper(TreeNode root, List<Integer> res){
//        if (root != null) {
//            if (root.left != null) {
//                helper(root.left, res);
//            }
//            res.add(root.val);
//            if (root.right != null){
//                helper(root.right, res);
//            }
//        }
//    }
//    
//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
//    }
//}

//Approach 2: Iterative - Stack
class Solution {
 public List<Integer> inorderTraversal(TreeNode root) {
     List<Integer> res = new ArrayList<>();
     Stack<TreeNode> stack = new Stack<>();
     TreeNode curr = root;
     while (curr != null || !stack.isEmpty()){ // 通常stack 不为空就指还有node substree没有遍历完
         while(curr != null){ // 一次遍历到最左边的leaf node
             stack.push(curr);
             curr = curr.left;
         }
         curr = stack.pop();// 遍历完该 node left subtree 把该nodeval加入stack
         res.add(curr.val);
         curr = curr.right;
     }
     return res;
 }
}


//Approach 3: Morris Traversal
//将 tree 变形
// TODO Need revision of this traversal