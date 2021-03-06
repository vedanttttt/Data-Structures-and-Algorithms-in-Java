
package binarytrees;

import java.util.*;
//import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Node {
  Node left;
  Node right;
  int data;
  int height;
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
  
  int maxLevel;
  public void leftViewOfTree(Node root,int level) {
	  if(root==null)
		  return;
	  
	  if(level>=maxLevel) {
		  System.out.print(root.data+" ");
		  maxLevel++;
	  }
	  
	  leftViewOfTree(root.left,level+1);
	  leftViewOfTree(root.right,level+1);
  }
  
  int mLevel;
  public void rightViewOfTree(Node root,int level) {
	  if(root==null)
		  return;
	  
	  if(level>=mLevel) {
		  System.out.print(root.data+" ");
		  mLevel++;
	  }
	  
	  rightViewOfTree(root.right,level+1);
	  rightViewOfTree(root.left,level+1);
  }
  
  public void inOrderUsingStack(Node root) {
	  if(root==null)
		  return ;
	  
	  Stack<Node> s = new Stack<>();
	  while(root!=null) {
		  s.push(root);
		  root = root.left;
	  }
	  
	  while(!s.isEmpty()) {
		  Node node = s.pop();
		  System.out.print(node.data+" ");
		  
		  if(node.right!=null) {
			  Node temp = node.right;
			  while(temp!=null) {
				  s.push(temp);
				  temp = temp.left;
			  }
		  }
	  }
  }
  
  public void preOrderUsingStack(Node root) {
	  if(root==null)
		  return;
	  
	  Stack<Node> s = new Stack<>();
	  s.push(root);
	  
	  while(!s.isEmpty()) {
		  Node node = s.pop();
		  System.out.print(node.data+" ");
		  if(node.right!=null)
			  s.push(node.right);
		  if(node.left!=null)
			  s.push(node.left);
	  }
  }
  
  public void postOrderUsingTwoStack(Node root) {
	  if(root==null)
		  return;
	  
	  Stack<Node> s1 = new Stack<>();
	  Stack<Node> s2 = new Stack<>();
	  
	  s1.push(root);
	  
	  while(!s1.isEmpty()) {
		  Node temp=s1.pop();
		  s2.push(temp);
		  if(temp.left!=null)
		   s1.push(temp.left);
		  if(temp.right!=null)
		   s1.push(temp.right);
	  }
	  
	  while(!s2.isEmpty()) {
		  System.out.print(s2.pop().data+" ");
	  }
  }
  
  public Node mirror(Node root) {
	  if(root==null)
		  return null;
	  
	  Stack<Node> s = new Stack<>();
	  s.push(root);
	  
	  while(!s.isEmpty()) {
		  Node node = s.pop();
		  Node temp=node.left;
		  node.left=node.right;
		  node.right=temp;
		  
		  if(node.left!=null)
			  s.push(node.left);
		  if(node.right!=null)
			  s.push(node.right);
	  }
	  return root;
  }
  
  public Node deleteTree(Node root) {
	  if(root==null)
		  return null;
	  
	  deleteTree(root.left);
	  deleteTree(root.right);
	  
	  System.out.println("Deleting node: "+ root.data);
	  root=null;
	  return root;
  }
  
  public int getLevel(Node root,int node,int level) {
	  if(root==null)
		  return -1;
	  if(root.data==node)
		  return level;
	  
	  int l;
	  l = getLevel(root.left,node,level+1);
	  if(l!=-1)
		  return l;
	  
	  return getLevel(root.right,node,level+1);
  }
  
  public void topView(Node root) {
	  if(root==null)
		  return;
	  
	  TreeMap<Integer,Integer> m = new TreeMap<>();
	  Queue<Node> q = new LinkedList<>();
	  q.add(root);
	  
	  while(!q.isEmpty()) {
		  Node temp = q.remove();
		  int hd = temp.height;
		  
		  if(!m.containsKey(hd))
			  m.put(hd,temp.data);
		  
		  if(temp.left!=null) {
			  q.add(temp.left);
			  temp.left.height=hd-1;
		  }
		  if(temp.right!=null) {
			  q.add(temp.right);
			  temp.right.height=hd+1;
		  }
	  }
	  System.out.println(m.values());
  }
  
  public void bottomView(Node root) {
	  if(root==null)
		  return;
	  
	  Map<Integer,Integer> m = new TreeMap<>();
	  Queue<Node> q = new LinkedList<>();
	  q.add(root);
	  
	  while(!q.isEmpty()) {
		  Node temp = q.remove();
		  int hd = temp.height;
		  
		  m.put(hd,temp.data);
		  if(temp.left!=null) {
			  q.add(temp.left);
			  temp.left.height=hd-1;
		  }
		  if(temp.right!=null) {
			  q.add(temp.right);
			  temp.right.height=hd+1;
		  }
	  }
	  System.out.println(m.values());
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
    
    //Printing left view of binary tree
    //a.leftViewOfTree(root,0);
    
    //Printing right view of tree
    //a.rightViewOfTree(root,0);
    
    //Inorder traversal without recursion
    //a.inOrderUsingStack(root);
    //System.out.println();
    
    //Preorder traversal without recursion
    //a.preOrderUsingStack(root);
    
    //Postorder traversal without recursion
    //a.postOrderUsingTwoStack(root);
    
    //Convert Binary Tree to its mirror image
    //Node node = a.mirror(root);
    //a.inorder(node);
    
    //Deleting binary tree
    //Node node = a.deleteTree(root);
    //a.preorder(node);
    
    //Get level of given node
    //System.out.println(a.getLevel(root,12,1));
    
    //Print top view
    //a.topView(root);
    
    //Print bottom view
    //a.bottomView(root);
    
    
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
