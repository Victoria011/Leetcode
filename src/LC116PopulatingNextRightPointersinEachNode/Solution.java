package LC116PopulatingNextRightPointersinEachNode;

import template.Node;

//Approach 1 Level order traversal
//class Solution {
//  public Node connect(Node root) {
//      if (root == null) return root;
//      Queue<Node> Q = new LinkedList<>();
//      Q.add(root);
     
//      while(Q.size() > 0){
//          int size = Q.size(); // next level nodes count
//          for(int i=0; i<size; i++){
//              Node node = Q.poll();
//              if (i < size-1){
//                  node.next = Q.peek();
//              }
//              if (node.left != null){
//                  Q.add(node.left);
//              }
//              if (node.right != null){
//                  Q.add(node.right);
//              }
//          }
//      }
//      return root;
//  }
//}

//Approach 2 Using previously established next pointers
public class Solution {
 public Node connect(Node root) {
     if (root == null) return root;
     Node leftmost = root;
     while(leftmost.left != null) {
         Node head = leftmost;
         while(head != null) {
             head.left.next = head.right;
             if(head.next != null){
                 head.right.next = head.next.left;
             }
             head = head.next;
         }
         leftmost = leftmost.left;
     }
     return root;
 }
}