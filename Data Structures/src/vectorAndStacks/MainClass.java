package vectorAndStacks;

import java.util.Stack;
//import java.util.Vector;

public class MainClass {
    
	public static void main(String args[]) {
		
		Stack<Integer> stack = new Stack<>();
		
		stack.push(12);
		stack.push(14);
		stack.push(16);
		int popped = stack.pop();
		 popped = stack.pop();
		System.out.println(popped);
		System.out.println(stack.peek());
	}
}
