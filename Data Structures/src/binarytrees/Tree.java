package binarytrees;

import java.util.Scanner;

class TreeNode{
	TreeNode left;
	TreeNode right;
	int data;
	
	public TreeNode(int data) {
		this.data= data;
	}
}

public class Tree {

	static Scanner sc = null;
	
	public static void main(String args[]) {
		
	sc = new Scanner(System.in);
	TreeNode root = createTree();	
	inOrder(root);
	System.out.println();
	preOrder(root);
	System.out.println();
	postOrder(root);
	}
	
	static TreeNode createTree() {
		
		TreeNode root = null;
		System.out.println("Enter data: ");
		int data = sc.nextInt();
		
		if(data == -1) return null;
		
		root = new TreeNode(data);
		
		System.out.println("Enter left for: " + data);
		root.left= createTree();
		
		System.out.println("Enter right for: " + data);
		root.right = createTree();
		
		return root;
	}
	
	static void inOrder(TreeNode root) {
		if(root==null)return;
		inOrder(root.left);
		System.out.print(root.data+"->");
		inOrder(root.right);
	}
	
	static void preOrder(TreeNode root) {
		if(root==null)return;
		System.out.print(root.data+"->");
		inOrder(root.left);
		inOrder(root.right);
	}
	
	static void postOrder(TreeNode root) {
		if(root==null)return;
		inOrder(root.left);
		inOrder(root.right);
		System.out.print(root.data+"->");
	}
}
