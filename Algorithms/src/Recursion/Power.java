//calculate power a^b using recursion.

package Recursion;

import java.util.*;
public class Power {

	public static void main(String srgs[]) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(pow(a,b));
		System.out.println(fastpow(a,b));
	}
	
	static int pow(int a,int b) {
		if(b==0)
			return 1;
		else
			return a*pow(a,b-1);
	}
	
	static int fastpow(int a,int b) {
		if(b==0)
			return 1;
		if(b%2==0)
			return fastpow(a*a,(b/2));
		return a*fastpow(a,b-1);
	}
}
