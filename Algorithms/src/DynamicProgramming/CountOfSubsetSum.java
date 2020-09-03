package DynamicProgramming;

public class CountOfSubsetSum {

	public static int equalToGivenSum(int[] ar,int sum) {
		if(ar.length==0||sum<=0)
			return 0;
		
		int n =ar.length;
		int[][] count=new int[n][sum+1];
		
		for(int i=0;i<n;i++) {
			count[i][0]=1;
		}
		
		for(int j=0;j<=sum;j++) {
			if(ar[0]==j)
				count[0][j]=1;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<=sum;j++) {
				
				int includingCurrentValue=0;
				int excludingCurrentValue=0;
				
				if(ar[i]<=j)
					includingCurrentValue=count[i-1][j-ar[i]];
				
				excludingCurrentValue=count[i-1][j];
				
				count[i][j]=includingCurrentValue+excludingCurrentValue;
			}
		}
		return count[n-1][sum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {2,3,7,1,4,5};
		int sum=7;
		System.out.println(CountOfSubsetSum.equalToGivenSum(arr,sum));
	}

}
