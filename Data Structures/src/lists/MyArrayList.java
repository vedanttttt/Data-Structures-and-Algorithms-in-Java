
package lists;

import java.util.ArrayList;

public class MyArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      ArrayList<String> fruits = new ArrayList<>();
      ArrayList<String> cars = new ArrayList<>();
       fruits.add("apple");
       fruits.add("orange");
       cars.add("audi");
       cars.add("bmw");
       fruits.addAll(cars);
       System.out.println(fruits);
       System.out.println(fruits.get(2));
       fruits.set(2,"merc");
       System.out.println(fruits);
       fruits.remove(1);
       System.out.println(fruits);
       System.out.println(fruits.size());
       System.out.println(fruits.contains("bmw"));
		
       String[] temp = new String[fruits.size()];
       
       fruits.toArray(temp);
       for(String e: temp) {
    	   System.out.println(e);
       }
	}

}
