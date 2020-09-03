package maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MainClass {


public static int  getHash(String s) {
	int hash=0;
	for(int i=0;i<s.length();i++) {
		hash+=s.charAt(i);
	}
	return hash;
}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*
		Map<String,Integer> numbers = new HashMap<>();
		
		numbers.put("one",1);
		numbers.put("two",2);
		numbers.put("zero",0);
		numbers.putIfAbsent("zero",9);
		//numbers.remove("two");
		System.out.println(numbers);
		
		Set<Entry<String,Integer>> entries = numbers.entrySet();
		for(Entry<String,Integer> entry : entries) {
			entry.setValue(entry.getValue()*100);
		}
		System.out.println(numbers);
		*/
		System.out.println(getHash("GOD"));
	}

}
