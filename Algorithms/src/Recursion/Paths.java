//Find all the paths in a n*m grid

package Recursion;

import java.util.Scanner;

public class Paths {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();//rows
		int m = sc.nextInt();//columns
		System.out.println(path(n,m));
		
	}
	static int path(int n,int m) {
		 if(n==1 || m==1)
			 return 1;
		 else
			 return path(n,m-1) + path(n-1,m);
	}
}
