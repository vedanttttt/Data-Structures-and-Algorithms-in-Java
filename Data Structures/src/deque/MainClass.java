package deque;

import java.util.ArrayDeque;

public class MainClass {
   
	public static void main(String args[]) {
	 ArrayDeque<Integer> ad= new ArrayDeque<>();
	ad.push(23);
	ad.push(45);
	ad.push(89);
	System.out.println(ad.pop());
	}
}
 