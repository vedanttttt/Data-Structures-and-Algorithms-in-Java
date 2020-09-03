import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
public class BinaryTree {

	 private  TreeNode root;
	 
	 private class TreeNode{
		 
		 private int data; //Generic Type
		 private TreeNode left;
		 private TreeNode right;
		 
		 public TreeNode(int data) {
			 this.data=data;
		 }
		  }
	 
	 public void createBinaryTree() {
		 TreeNode first = new TreeNode(1);
		 TreeNode second = new TreeNode(2);
		 TreeNode third = new TreeNode(3);
		 TreeNode fourth = new TreeNode(4);
		 TreeNode fifth = new TreeNode(5);
		 
		 root=first;//root-->first
		 first.left=second;
		 first.right=third;//second<--first-->third
		 
		 second.left=fourth;
		 second.right=fifth;
	 }
	 
	 public void preOrder(TreeNode root) {
		 if(root==null) // base case
			 return;
		 System.out.println(root.data+" ");
		 preOrder(root.left);
		 preOrder(root.right);
	 }
	 
	 public void iterativePreOrder() {
		 if(root==null)
			 return;
		 
		 Stack<TreeNode> stack = new Stack<>();
		 stack.push(root);
		 
		 while(!stack.isEmpty()) {
			 TreeNode temp = stack.pop();
			 System.out.print(temp.data+" ");
			 if(temp.right!=null)
				 stack.push(temp.right);
			 if(temp.left!=null)
				 stack.push(temp.left);
		 }
	 }
	
	 public void inOrder(TreeNode root) {
		 if(root==null)
			 return;
		 inOrder(root.left);
		 System.out.print(root.data+" ");
		 inOrder(root.right);
	 }
	 
	 public void iterativeInOrder() {
		 if(root==null)
			 return;
		 
		 Stack<TreeNode> stack = new Stack<>();
		 TreeNode temp=root;
		 while(!stack.isEmpty() || temp!=null) {
			 if(temp!=null) {
				 stack.push(temp);
				 temp=temp.left;
			 }
			 else {
				 temp=stack.pop();
				 System.out.print(temp.data+" ");
				 temp=temp.right;
			 }
		 }
	 }
	 
	 public void postOrder(TreeNode root) {
		 if(root==null)
			 return;
		 postOrder(root.left);
		 postOrder(root.right);
		 System.out.print(root.data+" ");
	 }
	 
	 public void LevelOrder() {
		 if(root==null)
			 return;
		 Queue<TreeNode> queue = new LinkedList<>();
		 queue.offer(root);
		 while(!queue.isEmpty()) {
			 TreeNode temp = queue.poll();
			 System.out.print(temp.data+" ");
			 if(temp.left!=null)
				 queue.offer(temp.left);
			 if(temp.right!=null)
				 queue.offer(temp.right);
		 }
	 }
	 
	 public TreeNode mirror(TreeNode root) {
		 if(root==null)
			 return null; 
		 TreeNode temp=root;
		 TreeNode param = null;
		 mirror(temp.left);
		 mirror(temp.right);
		 if(temp.left==null && temp.right==null)
			 return temp;
		 if(temp.left!=null && temp.right!=null) {
			 param=temp.left;
			 temp.left=temp.right;
			 temp.right=param;
		 }
		 else if(temp.left==null) {
			 temp.left=temp.right;
		     temp.right=null;
		 }
		 else if(temp.right==null) {
			 temp.right=temp.left;
		     temp.left=null;
		 }
		 return root;
		 }
	 
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
       // bt.preOrder(bt.root);
        //bt.iterativePreOrder();
      //  bt.inOrder(bt.root);
       // bt.iterativeInOrder();
       // bt.postOrder(bt.root);
          bt.LevelOrder();
          bt.mirror(bt.root);
          bt.LevelOrder();
	}

}
