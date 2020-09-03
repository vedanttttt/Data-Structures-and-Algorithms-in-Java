package queue;

import java.util.LinkedList;
import java.util.Queue;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		Queue<Integer> q = new LinkedList<>();
		
	q.add(23);
		q.add(56);
		q.add(78);
		System.out.println(q);
		
		System.out.println(q.remove());
		q.remove();
		System.out.println(q);
	//	q.remove();
	//	System.out.println(q);
	
		//q.remove();
	}

}
