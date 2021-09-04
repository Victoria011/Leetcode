package LC117PopulatingNextRightPointersinEachNode;

import template.Node;

//public class Solution {
//public Node connect(Node root) {
//if (root == null) return root;

//Queue<Node> queue = new LinkedList<Node>();
//queue.add(root);

//while(queue.size() > 0) {
//  int size = queue.size();
//  for (int i = 0; i<size; i++) { // iterating curr level all nodes
//      Node node = queue.poll(); 
//      if (i < size-1){
//          node.next = queue.peek();
//      }
     
//      if (node.left != null) {
//          queue.add(node.left);
//      }
//      if (node.right != null) {
//          queue.add(node.right);
//      }
//  }
//}
//return root;
//}
//}

//Approach 2 Using previously established next pointers
class Solution {
	Node prev, leftmost;
	
	private void processChild(Node childNode){
		if (childNode != null) {
			if (this.prev != null) {
				this.prev.next = childNode;
			} else {
				this.leftmost = childNode;
			}
			this.prev = childNode;
		}
	}
	
	public Node connect(Node root) {
		if (root == null) return root;
		this.leftmost = root;
		Node curr = leftmost;
		while(this.leftmost != null) {
			this.prev = null;
			curr = this.leftmost;
			this.leftmost = null;
			while(curr != null){
				this.processChild(curr.left);
				this.processChild(curr.right);
				curr = curr.next;
			}
		}
		return root;
	}
}