package sets;

import java.util.*;
public class MainClass {

	 public static void main(String args[]) {
		 Set<String> s = new LinkedHashSet<>();
		 
		 s.add("Audi");
		 s.add("Bmw");
		 s.add("Merc");
		 System.out.println(s.add("Kite"));
		 System.out.println(s.add("Merc"));
		 System.out.println(s);
	 }
}
