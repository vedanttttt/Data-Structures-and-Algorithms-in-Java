package deque;

import java.util.NoSuchElementException;

public class MyDeque<E> {

	 Node<E> head,tail;
	 
	 public void addToTail(E data) {
		 Node<E> x = new Node<>(data);
		 if(tail==null) {
			 tail=head=x;	
		 }
		 tail.next=x;
		 x.prev=tail;
		 tail=x;
	 }
	 
	 public E removeLast() throws Exception{
		 if(head==null)
			 throw new NoSuchElementException("Deque is empty");
		 Node<E> x = head;
		 head=head.next;
		 head.prev=null;
		 if(head==null)
			 tail=null;
		 x.next=null;
		 return x.data;
	 }
	 
	 public static class Node<E>{
		 E data;
		 Node<E> next,prev;
		 
		 public Node(E data){
			 this.data=data;
			 this.next=null;
			 this.prev=null;
		 }
	 }
	 
	 public static void main(String args[]) {
		 MyDeque md = new MyDeque();
		 md.addToTail(34);
		 
	 }
}
