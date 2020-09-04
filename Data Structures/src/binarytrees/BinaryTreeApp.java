
package binarytrees;

import java.util.Iterator;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
  Node left;
  Node right;
  int data;
}

class BinaryTree {
  
  public void inorder(Node node) {
    if(node == null) {
      return;
    }
    
    inorder(node.left);
    System.out.print(node.data + " ");
    inorder(node.right);
  }
  
  public void preorder(Node node) {
    if(node == null) {
      return;
    }
    
    System.out.print(node.data + " ");
    preorder(node.left);
    preorder(node.right);
  }
  
  public void postorder(Node node) {
    if(node == null) {
      return;
    }
    
    postorder(node.left);
    postorder(node.right);
    System.out.print(node.data + " ");
  }
  
  public int getSumOfNodes(Node root) {

	  if(root==null)
		  return 0;
	  
	  return root.data + getSumOfNodes(root.left) + getSumOfNodes(root.right);
  }
  
  public int getDiffEvenOdd(Node root) {
	  if(root==null)
		  return 0;
	  
	  return root.data - getDiffEvenOdd(root.left) - getDiffEvenOdd(root.right);
  }
  
  public int getNoOfLeafNodes(Node root) {
	  if(root==null)
		  return 0;
	  if(root.left==null && root.right==null)
		  return 1;
	  
	  return getNoOfLeafNodes(root.left) + getNoOfLeafNodes(root.right);
  }
  
  public int getHeight(Node root) {
	  if(root==null)
		  return -1;
	  
	  return Math.max(getHeight(root.left), getHeight(root.right)) +1;
  }
  
  public void printAtGivenLevel(Node root,int level) {
	  if(root==null)
		  return;
	  
	  if(level==0) {
		  System.out.print(root.data+" ");
		  return ;
	  }
	  
	  printAtGivenLevel(root.left,level-1);
	  printAtGivenLevel(root.right,level-1);
  }
  
  public void levelOrderTraversalUsingRecursion(Node root) {
	  if(root==null)
		  return;
	  
	  int height = getHeight(root);
	  for(int i=0;i<=height;i++) {
		  printAtGivenLevel(root,i);
		  System.out.println();
	  }
  }
  
  public void reverseLevelOrderTraversalWithoutRecursion(Node root) {
	  if(root==null)
		  return;
	  
	  Queue<Node> q = new LinkedList<>();
	  q.add(root);
	  Stack<Node> s = new Stack<>();
	  
	  while(!q.isEmpty()) {
		  Node node = q.poll();
		  s.push(node);
		  
		  if(node.right!=null)
			  q.add(node.right);
		  if(node.left!=null)
			  q.add(node.left);
	  }
	  
	  while(!s.isEmpty()) {
		  System.out.print(s.pop().data+" ");
	  }
  }
  
  public void levelOrderTraversalWithoutRecursionLineByLine(Node root) {
	  if(root==null)
		  return;
	  
	  Queue<Node> q = new LinkedList<>();
	  q.add(root);
	  
	  while(!q.isEmpty()) {
		  int size=q.size();
		  
		  for(int i=0;i<size;i++) {
			  Node node = q.poll();
			  System.out.print(node.data+" ");
			  
			  if(node.left!=null)
				  q.add(node.left);
			  if(node.right!=null)
				  q.add(node.right);
		  }
		  System.out.println();
	  }
  }
  
  public Node createNewNode(int val) {
    Node newNode = new Node();
    newNode.data = val;
    newNode.left = null;
    newNode.right = null;
    return newNode;
  }
}

public class BinaryTreeApp {

  public static void main(String[] args) {
  
    BinaryTree a = new BinaryTree();
    
    Node root = a.createNewNode(2);
    root.left = a.createNewNode(7);
    root.right = a.createNewNode(5);
    root.left.left = a.createNewNode(2);
    root.left.right = a.createNewNode(6);
    root.left.right.left = a.createNewNode(5);
    root.left.right.right = a.createNewNode(11);
    root.right.right = a.createNewNode(9);
    root.right.right.left = a.createNewNode(4);
    
   // System.out.println("Sum of nodes: " + a.getSumOfNodes(root));
    
    //Get difference of values at even and odd level
    //System.out.println("Diff of values: " + a.getDiffEvenOdd(root));
    
    //Similarly we can find no. of nodes in tree
    
    //Count total no. of leaf nodes
    //System.out.println(a.getNoOfLeafNodes(root));
    
    //Get height of a tree
    //System.out.println("Height of tree: " + a.getHeight(root));
    
    //Print elements at given level
    //a.printAtGivenLevel(root,2);
    
    //LevelOrderTraversal with Recursion
    //a.levelOrderTraversalUsingRecursion(root);
    
    //Reverse level order traversal using recursion
    //its easy now, just start for loop from i=h till i=0
    
    //LevelOrder traversal using queue,I know that 
    
    //Reverse Level Order traversal without recusrsion
    //a.reverseLevelOrderTraversalWithoutRecursion(root);
    
    //LevelOrderTraversal Line by line without recursion using queue
    //a.levelOrderTraversalWithoutRecursionLineByLine(root);
    
    
//    System.out.print("Inorder: ");
//    a.inorder(root);
//    System.out.println();
//
//    System.out.print("PreOrder: ");
//    a.preorder(root);
//    System.out.println();
//    
//    System.out.print("PostOrder: ");
//    a.postorder(root);
//    System.out.println();
    
  }

}
