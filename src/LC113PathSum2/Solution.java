package LC113PathSum2;

import template.TreeNode;
import java.util.ArrayList;
import java.util.List;

//Approach 1 Recursion
public class Solution {
    private void recurseTree(TreeNode node, int remainSum, List<Integer> pathNodes, List<List<Integer>> pathList){
        if (node == null) return;
        
        pathNodes.add(node.val);
        
        if ((remainSum == node.val) && (node.left == null) && (node.right == null)) { // if node is leaf and found one path - add to pathList
            pathList.add(new ArrayList<>(pathNodes));
        } else { // recurse on the left right subtree
            recurseTree(node.left, remainSum - node.val, pathNodes, pathList);
            recurseTree(node.right, remainSum - node.val, pathNodes, pathList);
        }
        // once finishing processing whole subtree of one node remove it
        pathNodes.remove(pathNodes.size()-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> pathList = new ArrayList<List<Integer>>();
        List<Integer> pathNodes = new ArrayList<Integer>();
        recurseTree(root, targetSum, pathNodes, pathList);
        return pathList;
    }
}