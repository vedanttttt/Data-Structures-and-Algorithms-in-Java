
public class SinglyLinkedLists {
   
	private  ListNode head;//head node to hold the list
	
	private static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			this.data=data;
			this.next=null;
		}
	}
	
	public void display() {
		 //Printing elements
		 ListNode current = head;
		 while(current != null) {
			 System.out.print(current.data + "-->");
			 current = current.next;
		 }
		 System.out.print("null");
	}
	
	public int length() {
		if(head == null)
			return 0;
		ListNode current = head;
		int count=0;
		while(current != null) {
			count++;
			current=current.next;
		}
		return count;
	}
	
	public void insertBeg(int data) {
		ListNode x = new ListNode(data);
		//x.next=null;
	//	if(head==null)
		//	head.next=x;
		
		x.next=head;
		head=x;
	}
	
	public void insertTail(int data) {
		ListNode x = new ListNode(data);
		x.next=null;
		if(head == null) {
			head=x;
			return;
		}
		ListNode current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next=x;
	}
	
	public void insertAfter(ListNode prev,int data) {
		ListNode x = new ListNode(data);
		x.next=prev.next;
		prev.next=x;
	}
	
	public void insertAtPos(int pos,int data) {
		ListNode x = new ListNode(data);
	//	ListNode previous=head;
		int count=1;
		ListNode previous = head;
		ListNode current = head;
		while(count != (pos-1)) {
			previous=previous.next;
			count++;
		}
		current=previous.next;
		x.next=current;
		previous.next=x;
	}
	
	public void deleteFirst() {
		ListNode temp = head;
		head = head.next;
		temp.next=null;
	}
	
	public ListNode deleteLast() {
		ListNode previous = head;
		while(previous.next.next != null) {
			previous=previous.next;
		}
		ListNode temp= previous.next;
		previous.next=null;
		return temp;
	}
	
	public void deletePos(int pos) {
		int count=1;
		ListNode previous = head;
		while(count != (pos-1)) {
			previous=previous.next;
			count++;
		}
		ListNode current = previous.next;
		previous.next=current.next;
		current.next=null;
	}
	
	public int search(int value) {
		ListNode current = head;
		int count=1;
		while(current != null) {
			if(current.data == value) {
				return count;
			}
			current=current.next;
			count++;
		}
		return 0;
	}
	
	public ListNode reverse() {
		ListNode previous=null;
		ListNode next = null;
		ListNode current = head;
		while(current != null) {
			next=current.next;
			current.next=previous;
			previous=current;
			current=next;
		}
		return previous;
	}
	
	public ListNode middleNode() {
		ListNode fastPtr = head;
		ListNode slowPtr = head;
		while(fastPtr != null && fastPtr.next != null) {
			slowPtr=slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		return slowPtr;
	}
	
	public ListNode nthend(int n) {
		ListNode mainPtr = head;
		ListNode refPtr = head;
		int count=0;
		while(count<n) {
			refPtr = refPtr.next;
			count++;
		}
		while(refPtr!=null) {
			refPtr=refPtr.next;
			mainPtr = mainPtr.next;
		}
		return mainPtr;
	}
     
	 public void insertSorted(int data) {
		 ListNode x = new ListNode(data);
		 x.next=null;
		 ListNode current=head;
		 ListNode temp = null;
		 while(current!=null && current.data<x.data) {
			 temp=current;
			 current=current.next;
		 }
		 x.next=current;
		 temp.next=x;
	 }
	
	public static void main(String args[]) {
		 //10-->8-->1-->11-->null
		 //10 as head node
	 SinglyLinkedLists sll = new SinglyLinkedLists();
		 sll.head=new ListNode(10);
		 //ListNode head = new ListNode(10);
		 ListNode second = new ListNode(8);
		 ListNode third = new ListNode(1);
		 ListNode fourth = new ListNode(11);
		 
		 //Attach them together to form a list.
		 sll.head.next=second;//10-->8
		 second.next=third;
		 third.next=fourth;
		 
		// sll.display();
		// System.out.println(sll.length());
		 sll.insertBeg(15);
		// sll.display();
		 
		 sll.insertTail(23);
		// sll.display();
		 sll.insertAfter(sll.head,32);
	//	 sll.display();
		// sll.insertAfter(second,32);
	     sll.insertAtPos(2,76); 
	 //    sll.display();
	     sll.deleteFirst();
	    sll.deleteFirst();
	 //   sll.display();
	     //sll.deleteLast();
	     sll.deleteLast();
	 //    sll.display();
	     sll.deletePos(3);
	 //    sll.display();
	     sll.deletePos(3);
	  //   sll.display();
	     sll.deletePos(3);
	     sll.insertBeg(23);
	     sll.insertBeg(34);
	     sll.insertBeg(56);
	 //   sll.display();
	    System.out.println(sll.middleNode().data);
	   //  System.out.println(sll.search(98));
	    ListNode result = sll.nthend(3);
	    System.out.println(result.data);
	    sll.deleteFirst();
	    sll.deleteFirst();
	    sll.deleteFirst();
	    sll.deleteFirst();
	   // sll.display();
	    sll.insertTail(20);
	    sll.insertTail(30);
	    sll.insertTail(40);
	    sll.insertTail(50);
	    sll.display();
	    sll.insertSorted(35);
	    sll.display();
	 }
}
