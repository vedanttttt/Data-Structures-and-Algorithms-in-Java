package DynamicProgramming;

public class MaxSumOfArrayEle {

	public static int NotConsecutive(int[] ar) {
		if(ar.length==0)
			return 0;
		
		if(ar.length==1)
			return 1;
		
		int[] dp = new int[ar.length];
		dp[0]=ar[0];
		dp[1]=ar[0]>ar[1] ? ar[0] :ar[1];
		
		for(int i=2;i<ar.length;i++) {
			dp[i]=Math.max(dp[i-1],ar[i]+dp[i-2]);
		}
		return dp[ar.length-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = {4,2,3,5,1,6,7};
		System.out.println(MaxSumOfArrayEle.NotConsecutive(arr));
	}

}
