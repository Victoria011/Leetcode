package LC103BinaryTreeZigzagLevelOrderTraversal;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ArrayDeque;
import template.TreeNode;

// Approach 1 BFS
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<List<Integer>>();
        if (root == null) return levels;
        boolean left_right = true; // true - left to right, false - right to left
        
        ArrayDeque<TreeNode> nextLevel = new ArrayDeque<TreeNode>(){{offer(root);}};
        ArrayDeque<TreeNode> currLevel = new ArrayDeque<TreeNode>();
        
        while(! nextLevel.isEmpty()){
            currLevel = nextLevel.clone();
            nextLevel.clear();
            levels.add(new ArrayList<Integer>());
            Iterator<TreeNode> it = currLevel.descendingIterator();
            while(it.hasNext()) {
                TreeNode node = it.next();
                levels.get(levels.size()-1).add(node.val);
                if (left_right){
                    if (node.left != null) nextLevel.offer(node.left);
                    if (node.right != null) nextLevel.offer(node.right);
                } else {
                    if (node.right != null) nextLevel.offer(node.right);
                    if (node.left != null) nextLevel.offer(node.left);
                }
            }
            left_right = !left_right;
        }
        return levels;
    }
}

// Approach 2 DFS
//class Solution {
// protected void DFS(TreeNode node, int level, List<List<Integer>> results) {
//     if (level >= results.size()){ //. if first time visited
//         LinkedList<Integer> newLevel = new LinkedList<Integer>();
//         newLevel.add(node.val);
//         results.add(newLevel);
//     } else {
//         if (level % 2 == 0) { // identify which direction
//             results.get(level).add(node.val);
//         } else {
//             results.get(level).add(0, node.val); //. the reason for using linkedlist easy to add at head/tail
//         }
//     }
//     
//     if (node.left != null) DFS(node.left, level + 1, results);
//     if (node.right != null) DFS(node.right, level + 1, results);
// }
// 
// public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//     List<List<Integer>> results = new ArrayList<List<Integer>>();
//     if (root == null) return results;
//     DFS(root, 0, results);
//     return results;
// }
//}