package LC112PathSum;
import template.TreeNode;
//public class Solution {
//    public boolean hasPathSum(TreeNode root, int targetSum) {
//        if (root == null){
//            return false;
//        }
//        return dfs(root, targetSum);
//    }
//    
//    public boolean dfs(TreeNode root, int targetSum){
//        if ((root.left == null) && (root.right == null) ) {
//            if (root.val == targetSum) return true;
//            return false;
//        }
//        boolean tmp = false;
//        if (root.left != null){
//            tmp = (tmp || dfs(root.left, targetSum-root.val));
//        }
//        if (root.right != null){
//            tmp = (tmp || dfs(root.right, targetSum-root.val));
//        }
//        
//        return tmp;
//    }
//}
// 以上的精简写法：
class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		sum -= root.val;
		if ((root.left == null) && (root.right == null))
			return (sum == 0);
		return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
  }
}

//Approach 2  iteration (same complexity)
//class Solution {
// public boolean hasPathSum(TreeNode root, int targetSum) {
//     if (root == null) return false;
//     
//     LinkedList<TreeNode> node_stack = new LinkedList();
//     LinkedList<Integer> sum_stack = new LinkedList(); // remained sum
//     node_stack.add(root);
//     sum_stack.add(sum - root.val);
//     
//     TreeNode node;
//     int curr_sum;
//     while( !node_stack.isEmpty()) {
//         node = node_stack.pollLast();
//         curr_sum = sum_stack.pollLast;
//         if ((node.right == null) && (node.left == 0 ) && (curr_sum == 0)) return true;
//         
//         if (node.left != null) {
//             node_stack.add(node.left);
//             sum_stack.add(curr_sum - node.left.val)
//         }
//         
//         if (node.right != null) {
//             node_stack.add(node.right);
//             sum_stack.add(curr_sum - node.right.val);
//         }
//     }
//     return false;
//     
// }
//}
