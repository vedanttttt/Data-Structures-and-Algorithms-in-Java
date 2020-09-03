//String: Print all permutations of a given string

package Recursion;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

	static Set<String> set = new HashSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        permutations("abcd",0,3);
	}

	static void permutations(String s,int l,int r) {
		if(l==r) {
			if(set.contains(s))
				return;
			set.add(s);
			System.out.println(s);
		    return;
		}
		for(int i=l;i<=r;i++) {
			s=interchangeChar(s,l,i);
			permutations(s,l+1,r);
			s=interchangeChar(s,l,i); //BackTracking
		}
	}
	
	static String interchangeChar(String s,int a,int b) {
		char[] ar = s.toCharArray();
		char temp = ar[a];
		ar[a] = ar[b];
		ar[b] = temp;
		return String.valueOf(ar);
	}
}




 
