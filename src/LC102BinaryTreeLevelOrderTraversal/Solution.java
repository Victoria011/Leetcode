package LC102BinaryTreeLevelOrderTraversal;

import java.util.List;

import template.TreeNode;

import java.util.ArrayList;

//recursion
//NOTE level是几 output ArrayList就应该有几个element (sub ArrayList)
public class Solution {
 List<List<Integer>> levels = new ArrayList<List<Integer>>();
 
 public void helper(TreeNode node, int level) {
     if (levels.size() == level) levels.add(new ArrayList<Integer>());
     
     levels.get(level).add(node.val);
     
     if (node.left != null) helper(node.left, level + 1);
     if (node.right != null) helper(node.right, level + 1);
 }
 
 public List<List<Integer>> levelOrder(TreeNode root) {
     //base case
     if (root == null) return levels;
     helper(root, 0);
     return levels;
     
 }
}


//This method getting err because only add one node's children in single list while all nodes in that level should be in same list
//class Solution {
//  List<List<Integer>> levels = new ArrayList<List<Integer>>();
//  Queue<TreeNode> visit = new LinkedList();
 
//  public void helper(TreeNode root) {
//      while(!visit.isEmpty()) {
//          TreeNode curr = visit.poll();
//          List<Integer> tmp = new ArrayList<Integer>();
//          if (curr.left != null){
//              visit.add(curr.left);
//              tmp.add(curr.left.val);
//          } 
//          if (curr.right != null) {
//              visit.add(curr.right);
//              tmp.add(curr.right.val);
//          }
//          if (!tmp.isEmpty()) levels.add(tmp);
//      }
//  }
 
//  public List<List<Integer>> levelOrder(TreeNode root) {
//      if (root == null) return levels;
//      visit.add(root);
//      List<Integer> tmp = new ArrayList<Integer>();
//      tmp.add(root.val);
//      levels.add(tmp);
//      helper(root);
//      return levels;
//  }
//}