package DynamicProgramming;

public class MaximumSumIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSumIncreasingSubsequence ms=new MaximumSumIncreasingSubsequence();
		int[] a = {7,1,4,8,11,2,14,3};
		
		System.out.println(ms.findSum(a));
	}
	
	public int findSum(int[] a) {
		int[] mis=new int[a.length];
		for(int i=0;i<mis.length;i++) {
			mis[i]=a[i];
		}
		int maxSum=a[0];
		for(int i=1;i<mis.length;i++) {
			for(int j=0;j<i;j++) {
				if((a[j]<a[i]) && mis[j]+a[i]>mis[i]) {
					mis[i]=a[i]+mis[j];
					}
			}
			maxSum=Math.max(maxSum,mis[i]);
			//maxLength=sum[i];
		}
		return maxSum;
	}

}
