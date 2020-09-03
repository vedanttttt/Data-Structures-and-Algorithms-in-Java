import java.util.NoSuchElementException;

public class DoublyLinkedLists {

	 private ListNode head;
	 private ListNode tail;
	 private int length;
	 
	private  class ListNode{
		private int data;
		private ListNode next;
		private ListNode prev;
		
		public ListNode(int data) {
			this.data=data;
		}
	}
	 
	public DoublyLinkedLists() {
		this.head=null;
		this.tail=null;
		this.length=0;
	}
	
	public Boolean isEmpty() {
		return length==0;
	    //or return length==0;
	}
	
	public int length() {
		return length;
	}
	
	public void displayFor() {
		if(head==null)
			return;
		ListNode current = head;
		while(current != null) {
			System.out.print(current.data+"-->");
			current=current.next;
		}
		System.out.print("null");
	}
	
	public void displayBack() {
		if(tail==null)
			return;
		ListNode temp = tail;
		while(temp!=null) {
			System.out.print(temp.data+"-->");
			temp=temp.prev;
		}
		System.out.print("null");
	}
	
	public void insertLast(int data) {
		ListNode x = new ListNode(data);
		x.next=null;
		if(isEmpty()) {
			head=x;
		}
		else {
			tail.next=x;
		
		x.prev=tail;
		tail=x;
		length++;
		}
	}
	
	public void insertBeg(int data) {
		ListNode x = new ListNode(data);
		if(isEmpty())
			tail=x;
		else
			head.prev=x;
		x.next=head;
		head=x;
		length++;
		//System.out.println(head.data);
	}
	
	public ListNode deleteFirst() {
		if(isEmpty())
			throw new NoSuchElementException();
		ListNode temp=head;
		if(head==tail)
			tail=null;
		else {
			head.next.prev=null;
		}
		head=head.next;
		temp.next=null;
		return temp;
	}
	
	public ListNode deleteLast() {
		if(isEmpty())
			throw new NoSuchElementException();
		ListNode temp=tail;
		if(head==tail)
			head=null;
		else {
			tail.prev.next=null;
			}
		tail=tail.prev;
		temp.prev=null;
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      DoublyLinkedLists dll = new DoublyLinkedLists();
      dll.insertBeg(10);
      dll.insertBeg(20);
      //dll.displayBack();
     // dll.displayFor();
    //  System.out.println(dll.length);
   //   System.out.println(dll.head.data);
      dll.insertLast(5);
    //  dll.displayFor();
   //   System.out.println();
   //   dll.displayBack();
  //    ListNode y = dll.deleteFirst();
    //  dll.displayFor();
   //   System.out.println(y.data);
       dll.deleteLast();
       dll.displayFor();
	}

}
