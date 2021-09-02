package LC104MaximumDepthofBinaryTree;
import template.TreeNode;
import java.util.LinkedList;
//Approach 1 Recursion
//class Solution {
//  public int maxDepth(TreeNode root) {
//      if (root == null) return 0;
//      if ((root.left == null) && (root.right == null)) return 1;
     
//      int max_depth = Integer.MIN_VALUE;
//      if (root.left != null) {
//          max_depth = Math.max(maxDepth(root.left), max_depth);
//      }
//      if (root.right != null) {
//          max_depth = Math.max(maxDepth(root.right), max_depth);
//      }
//      max_depth++;
//      return max_depth;
//  }
//}
//Approach 2 DFS iteration
//class Solution {
//  public int maxDepth(TreeNode root) {
//      LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//      if (root == null) return 0;
//      stack.add(new Pair(root,1));
    
//      int max_depth = Integer.MIN_VALUE;
//      while(!stack.isEmpty()) {
//          Pair<TreeNode, Integer> current = stack.pollLast();
//          root = current.getKey();
//          int current_depth = current.getValue();
//          if((root.left == null) && (root.right == null)) {
//              max_depth = Math.max(max_depth, current_depth);
//          }
//          if (root.left != null){
//              stack.add(new Pair(root.left, current_depth + 1));
//          }
//          if (root.right != null) {
//              stack.add(new Pair(root.right, current_depth + 1));
//          }
//      }
//      return max_depth;
//  }
//}


//Approach 3 iteration FILO - stack (和 approach 2 一个意思)

public class Solution {
 public int maxDepth(TreeNode root) {
     LinkedList<TreeNode> stack = new LinkedList<>();
     LinkedList<Integer> depths = new LinkedList<>();
     if (root == null) return 0;
     stack.add(root);
     depths.add(1);
     
     int depth = 0, curr_depth = 0;
     while(!stack.isEmpty()) {
         root = stack.pollLast();
         curr_depth = depths.pollLast();
         if (root != null) {
             depth = Math.max(depth, curr_depth);
             stack.add(root.left);
             stack.add(root.right);
             depths.add(curr_depth + 1);
             depths.add(curr_depth + 1);
         }
     }
     return depth;
 }
}