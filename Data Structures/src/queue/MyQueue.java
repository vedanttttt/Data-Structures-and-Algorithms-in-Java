package queue;

import java.util.NoSuchElementException;

public class MyQueue {
 
	private ListNode front;
	 private ListNode rear;
	 private int length;
	
	 public MyQueue() {
		 this.front=null;
		 this.rear=null;
		 this.length=0;
	 }
	 
	private class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public int length() {
		return  length;
	}
	
	public Boolean isEmpty() {
		return length==0;
	}
	
	public void enqueue(int data) {
		ListNode x = new ListNode(data);
		if(isEmpty()) {
			front=x;
		}
		else {
			rear.next=x;
		}
		rear=x;
		length++;
	}
	
	public void display() {
		if(isEmpty()) {
			return;
		}
		ListNode temp=front;
		while(temp!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.next;
		}
		System.out.println("null");
	}
	
	public int dequeue()  throws Exception{
		if(isEmpty()) {
			throw new NoSuchElementException("Queue is empty");
		}
		   int result = front.data;
		   front=front.next;
		   if(front==null) {
			   rear=null;
		   }
		   length--;
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		MyQueue q = new MyQueue();
		q.enqueue(34);
		q.enqueue(56);
		q.display();
		int a=q.dequeue();
		System.out.println(a);
		q.dequeue();
		q.dequeue();
		
	}
}
