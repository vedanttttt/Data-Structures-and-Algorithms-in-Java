package lists;

//import java.util.*;

public class MainLinkedList<E> {
  
	Node<E> head;
	 static class Node<E>{
		 E data;
		 Node<E> next;
		 
		 public Node(E data) {
			 this.data=data;
			 next=null;
		 }
	 }
	
	public void add(E data) {
		 Node<E> toAdd = new Node<E>(data);
		 if(isEmpty()) {
			 head=toAdd;
			 return;
		 }
		 Node<E> temp=head;
		 while(temp.next!=null) {
			 temp=temp.next;
		 }
		 temp.next=toAdd;
	 }
	 
	public  boolean isEmpty() {
		 return head==null;
	 }
	 
	public void print() {
		 Node<E> temp=head;
		 while(temp!=null) {
			 System.out.print(temp.data+"-->");
			 temp=temp.next;
		 }
		 System.out.print("Null");
	 }
	
	public E removeLast() throws Exception{
		if(isEmpty()) {
			throw new Exception("List is empty");
		}
		Node<E> temp=head;
		if(temp.next==null) {
			Node toRemove=temp;
			head=null;
			return (E) toRemove.data;
		}
		while(temp.next.next!= null) {
			temp=temp.next;
		}
		Node result = temp.next;
		temp.next=null;
		return  (E) result.data;
	}
	 
	public static void main(String args[]) {
		MainLinkedList mll = new MainLinkedList();
		mll.add(23);
		mll.add(54);
		mll.print();
	     System.out.println(mll.isEmpty());
	}
}
