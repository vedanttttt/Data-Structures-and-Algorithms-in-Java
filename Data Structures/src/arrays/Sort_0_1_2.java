package arrays;

import java.util.Arrays;

public class Sort_0_1_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ar[] = {0,1,1,0,1,2,1,2,0,0,0,1};
		int n = ar.length;
		int l = 0,r =n-1;
		
		while(ar[l]==0)
			l++;
		while(ar[r]==2)
			r--;
		
		for(int i=l;i<=r;i++) {
			if(ar[i] ==0) {
				int temp=ar[i];
				ar[i]=ar[l];
				ar[l]=temp;
				l++;
			}
			else if(ar[i] ==2) {
				int temp=ar[i];
				ar[i]=ar[r];
				ar[r]=temp;
				i--;
				r--;
			}
			//System.out.println(ar[i]);
		}
		
		System.out.println(Arrays.toString(ar));
	}

}
