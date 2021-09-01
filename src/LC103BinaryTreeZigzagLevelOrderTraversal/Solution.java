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