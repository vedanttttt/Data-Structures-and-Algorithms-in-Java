package bst;

class Node{
	int data;
	Node left;
	Node right;	
}

class BST{
	
	public Node createNewNode(int k) {
		Node a = new Node();
		a.data=k;
		a.left=null;
		a.right=null;
		return a;
	}
	
	public Node insert(Node node,int val) {
		if(node==null) {
			return createNewNode(val);
		}
		if(val<node.data) {
			node.left=insert(node.left,val);
		}
		else if(val>node.data) {
			node.right = insert(node.right,val);
		}
		return node;
	}
	
	public Node delete(Node node,int val) {
		if(node==null)
			return null;
		if(val<node.data) {
			node.left = delete(node.left,val);
		}
		else if(val>node.data) {
			node.right = delete(node.right,val);
		}
		else {
			if(node.left==null || node.right==null) {
				Node temp=null;
				temp = node.left==null ? node.right : node.left;
				
				if(temp==null)
					return null;
				else
					return temp;
			}
			// now if both children are not null, we need to get inorder successor
			else {
				Node successor = getSuccessor(node);
				node.data=successor.data;
				node.right = delete(node.right,4);
				return node;
			}
		}
		return node;
	}
	
	public Node getSuccessor(Node node) {
		if(node==null)
			return null;
		Node temp=node.right;
		while(temp.left !=null) {
			temp = temp.left;
		}
			return temp;
	}
	
	public void inOrder(Node node) {
		if(node==null)
			return;
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	public boolean isNodePresent(Node node,int val) {
		if(node==null)
			return false;
		boolean isPresent=false;
		while(node!=null) {
		if(val>node.data) {
			node = node.right;
		}
		else if(val<node.data) {
		 node = node.left;
		}
		else if(val==node.data) {
			isPresent=true;
			break;
	}}
		return isPresent;
	}
}

public class BSTApp {

	public static void main(String[] args) {
		BST a = new BST();
		Node root=null;
		//8,3,6,10,4,7,1,14,13
		
		root = a.insert(root, 8);
		root = a.insert(root, 3);
		root = a.insert(root, 6);
		root = a.insert(root, 10);
		root = a.insert(root, 4);
		root = a.insert(root, 7);
		root = a.delete(root,1);
		a.inOrder(root);
		System.out.println(a.isNodePresent(root, 11));
		//System.out.println(root.data);
	}
}
