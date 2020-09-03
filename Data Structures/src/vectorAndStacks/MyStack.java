package vectorAndStacks;

import lists.MainLinkedList;

public class MyStack<E> {
   
	private MainLinkedList<E> ll = new MainLinkedList<>();
	
	void push(E e) {
		ll.add(e);
	}
	
	E pop() throws Exception{
		if(ll.isEmpty())
			throw new Exception("Popping from empty list");
		return ll.removeLast();
	}
	
	E peek() {
		
	}

}
