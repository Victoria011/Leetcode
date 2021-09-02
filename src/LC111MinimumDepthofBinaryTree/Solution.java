package LC111MinimumDepthofBinaryTree;

import template.TreeNode;
//
//public class Solution {
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        if ((root.left == null) && (root.right == null)) return 1;
//        if ((root.left == null) || (root.right == null)) {
//            if (root.left == null) {
//                return minDepth(root.right) + 1;
//            } else {
//                return minDepth(root.left) + 1;
//            }
//        }
//        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
//    }
//}
// 精简一点
//int min_depth = Integer.MAX_VALUE;
//if (root.left != null) {
//  min_depth = Math.min(minDepth(root.left), min_depth);
//}
//if (root.right != null) {
//  min_depth = Math.min(minDepth(root.right), min_depth);
//}
//
//return min_depth + 1;

// Approach 2 DFS iteration
//class Solution {
//    public int minDepth(TreeNode root) {
//        LinkedList<Pair<TreeNode, Integer>> stack = new LinkedList<>();
//        if (root == null) return 0;
//        stack.add(new Pair(root,1));
//        
//        int min_depth = Integer.MAX_VALUE;
//        while(!stack.isEmpty()) {
//            Pair<TreeNode, Integer> current = stack.pollLast();
//            root = current.getKey();
//            int current_depth = current.getValue();
//            if((root.left == null) && (root.right == null)) {
//                min_depth = Math.min(min_depth, current_depth);
//            }
//            if (root.left != null){
//                stack.add(new Pair(root.left, current_depth + 1));
//            }
//            if (root.right != null) {
//                stack.add(new Pair(root.right, current_depth + 1));
//            }
//        }
//        return min_depth;
//    }
//}

//Approach 3 BFS 这样遍历到了可以立即结束节省时间
class Solution {
 public int minDepth(TreeNode root) {
     LinkedList<Pair<TreeNode, Integer>> queue = new LinkedList<>();
     if (root == null) return 0;
     queue.add(new Pair(root,1));
     
     int current_depth = 0;
     while(!queue.isEmpty()) {
         Pair<TreeNode, Integer> current = queue.poll();
         root = current.getKey();
         current_depth = current.getValue();
         if ((root.left == null) && (root.right == null)){ // is leaf
             break;
         }
         if (root.left != null) {
             queue.add(new Pair(root.left, current_depth + 1));
         }
         if (root.right != null) {
             queue.add(new Pair(root.right, current_depth + 1));
         }
     }
     return current_depth;
     
 }
}