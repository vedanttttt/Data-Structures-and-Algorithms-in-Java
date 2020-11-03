package Greedy;

public class MaximumProductSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1,-1,-2,4,3};
		int n = a.length;
		System.out.println(maxProductSubset(a,n));
	}

	public static int maxProductSubset(int[] a,int n) {
		if(n==1)
			return a[0];
		
		//Find the count of negative numbers,count of zeroes,negative number with least absolute value and product of non-zero numbers
		int max_neg= Integer.MIN_VALUE;
		int count_neg=0,count_zero=0;
		int prod=1;
		for(int i=0;i<n;i++) {
			if(a[i]==0) {
				count_zero++;
				continue;
			}
			
			if(a[i]<0) {
				count_neg++;
				max_neg = Math.max(max_neg, a[i]);
			}
			
			prod *= a[i];
		}
		
		if(count_zero==n)
			return 0;
		
		//if there are odd number of negative numbers
		if(count_neg % 2==1) {
			
			//Exceptional case: there is only negative and all other are zeroes
			if(count_neg==1 && count_zero>0 && count_zero+count_neg==n)
				return 0;
			
			//otherwise result is product of all non-zeroes divided by negative number with least absolute value.
			prod /= max_neg;
		}
		
		return prod;
	}
}
