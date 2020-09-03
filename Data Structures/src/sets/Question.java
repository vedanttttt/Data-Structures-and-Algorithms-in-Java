package sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//Q. Given an array, find if their exists a subarray with sum equals to zero.

public class Question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2,1,3,-4,-2};
		int k=9;
		boolean found=false;
		
		Set<Integer> set = new HashSet<>();
		int sum=0;
       /*   for(int element : a) {
        	  set.add(sum);
			 sum += element;
			 if(set.contains(sum-k)) {
				 found=true;
				 break;
			 }
          }
          */
          
		//int sum=0;
		ArrayList<Integer> al = new ArrayList<>();
		for(int i:a) {
			al.add(sum);
			sum=sum+i;
			if(al.contains(sum-k)) {
				found=true;
				break;
			}
		}
		
		
          System.out.println("found: "+found);
	}

}
