package LC107BinaryTreeLevelOrderTraversal2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import template.TreeNode;

//Approach 1: Recursion: DFS Preorder Traversal
public class Solution {
 List<List<Integer>> levels = new ArrayList<List<Integer>>();
 
 public void helper(TreeNode node, int level){
     if (levels.size() == level) levels.add(new ArrayList<Integer>()); 
     levels.get(level).add(node.val);
     if (node.left != null) helper(node.left, level + 1);
     if (node.right != null) helper(node.right, level + 1); 
     
 }
 
 public List<List<Integer>> levelOrderBottom(TreeNode root) {
     if (root == null) return levels;
     helper(root,0);
     Collections.reverse(levels);
     return levels;
 }
}

//Approach 2: Iteration: BFS Traversal
//class Solution {
//  public List<List<Integer>> levelOrderBottom(TreeNode root) {
//      List<List<Integer>> levels = new ArrayList<List<Integer>>();
//      if (root == null) return levels;
//      
//      ArrayDeque<TreeNode> nextLevel = new ArrayDeque(){{offer(root);}};
//      ArrayDeque<TreeNode> currLevel = new ArrayDeque();
//      
//      while(!nextLevel.isEmpty()) {
//          currLevel = nextLevel.clone();
//          nextLevel.clear();
//          levels.add(new ArrayList<Integer>());
//          
//          for (TreeNode node: currLevel) {
//              levels.get(levels.size()-1).add(node.val);
//              
//              if (node.left != null) nextLevel.offer(node.left);
//              if (node.right != null) nextLevel.offer(node.right);
//              
//          }
//      }
//      
//      Collections.reverse(levels);
//      return levels;
//  }
//}