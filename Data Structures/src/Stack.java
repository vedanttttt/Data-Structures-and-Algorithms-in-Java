import java.util.EmptyStackException;

public class Stack {
 
	 private int length;
	 private ListNode top;
	 
	 private class ListNode{
		 private int data;
		 private ListNode next;
		 
	  public ListNode(int data) {
		  this.data=data;
		  this.next=null;
	  }
	 }
	 
	 public Stack() {
		 this.top=null;
		 length=0;
	 }
	 
	 public int length() {
		 return length;
	 }
	 
	 public Boolean isEmpty() {
		 return length==0;
	 }
	 
	 public void push(int data) {
		 ListNode x = new ListNode(data);
		 x.next=top;
		 top=x;
		 length++;
	 }
	 
	 public int pop() {
		 if(isEmpty())
			 throw new EmptyStackException();
		 int result=top.data;
		 top=top.next;
		 length--;
		 return result;
	 }
	 
	 public int peek() {
		 if(isEmpty())
			 throw new EmptyStackException();
		 return top.data;
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Stack stack = new Stack();
        stack.push(25);
        stack.push(45);
        
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
       // stack.pop();
	}

}
