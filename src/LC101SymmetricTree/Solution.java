package LC101SymmetricTree;


import template.TreeNode;



// Approach 1 recursion
//public class Solution {
//    public boolean isSymmetric(TreeNode root) {
//        return root == null || helper(root.left, root.right);
//    }
//    
//    private boolean helper(TreeNode left, TreeNode right){
//        if (left == null || right == null) return (left == right);
//        if (left.val != right.val) return false;
//        return helper(left.left, right.right) && helper(left.right, right.left);
//    }
//}

//Approach 2 Iteration (why use Queue/Stack)

import java.util.Queue;
import java.util.LinkedList;

public class Solution {
 public boolean isSymmetric(TreeNode root) {
     if (root == null) return true;
     Queue<TreeNode> q = new LinkedList();
     
     q.add(root.left);
     q.add(root.right);
     while(!q.isEmpty()){
         TreeNode left = q.poll();
         TreeNode right = q.poll();
         
         if (left == null && right == null) continue;
         if (left == null || right == null || left.val != right.val) return false;
         
         q.add(left.left);
         q.add(right.right);
         q.add(left.right);
         q.add(right.left);
         
     }
     
     return true;
 }
}