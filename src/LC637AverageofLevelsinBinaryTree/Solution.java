package LC637AverageofLevelsinBinaryTree;

import java.util.List;
import java.util.ArrayList;

import template.TreeNode;


//Approach 1: DFS
//public class Solution {
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Integer> count = new ArrayList<>();
//        List<Double> res = new ArrayList<>();
//        average(root, 0, res,count);
//        for (int i=0; i < res.size(); i++) {
//            res.set(i, res.get(i) / count.get(i));
//        }
//        return res;
//    }
//    
//    // i - level
//    public void average(TreeNode node, int i, List<Double> sum, List<Integer> count){
//        if (node == null) return;
//        if (i < sum.size()) { // level already been visited
//            sum.set(i,sum.get(i) + node.val);
//            count.set(i, count.get(i) + 1);
//        } else {
//            sum.add(1.0 * node.val); // new level never been reached
//            count.add(1);
//        }
//        average(node.left, i + 1, sum, count);
//        average(node.right, i + 1, sum, count);
//    }
//}

//Approach 2:
//Approach 2: BFS
import java.util.LinkedList;
import java.util.Queue;
class Solution {
 public List<Double> averageOfLevels(TreeNode root) {
     List<Double> res = new ArrayList<>();
     Queue<TreeNode> queue = new LinkedList<>();
     queue.add(root);
     while(!queue.isEmpty()) {
         long sum = 0, count = 0;
         Queue<TreeNode> temp = new LinkedList<>(); // storing next level nodes
         while(!queue.isEmpty()){
             TreeNode n = queue.remove();
             sum += n.val;
             count++;
             if (n.left != null) temp.add(n.left);
             if (n.right != null) temp.add(n.right);
         }
         queue = temp;
         res.add(sum * 1.0 / count);
     }
     return res;
 }
}