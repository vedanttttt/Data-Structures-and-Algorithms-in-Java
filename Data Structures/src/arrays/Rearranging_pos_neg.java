package arrays;

import java.util.Arrays;

public class Rearranging_pos_neg {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {-12,11,-13,-5,6,-7,5,-3,11};
		int n = ar.length;
		
		int l=0,r=n-1;
		
		while(l<r) {
			while(ar[l] < 0)
				l++;
			while(ar[r]>0)
				r--;
			
			if(l<r) {
				int temp=ar[l];
				ar[l]=ar[r];
				ar[r]=temp;
				l++;
				r--;
			}
		}
		
		System.out.println(Arrays.toString(ar));
	}

}
