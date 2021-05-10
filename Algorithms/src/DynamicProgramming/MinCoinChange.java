package DynamicProgramming;

public class MinCoinChange {

	public static int toMakeSum(int[] coins,int sum) {
		if(coins.length==0 || sum<=0)
			return 0;
		
		int[][] arr = new int[coins.length][sum+1];
		for(int i=0;i<coins.length;i++) {
			arr[i][0]=0;
		}
		
		for(int i=0;i<coins.length;i++) {
			for(int j=1;j<=sum;j++) {
				
				int excludingCurrentCoin=Integer.MAX_VALUE; //take it Integer.MAX_VALUE-1 , so that when we add 1 to it , it doesnt overflow
				int includingCurrentCoin=Integer.MAX_VALUE;
				
				if(i>0)
					excludingCurrentCoin=arr[i-1][j];
				if(coins[i]<=j)
					includingCurrentCoin=1+arr[i][j-coins[i]];
				
				arr[i][j]=Math.min(excludingCurrentCoin, includingCurrentCoin);
			}
		}
		
		return arr[coins.length-1][sum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins= {1,2,3};
		int sum=8;
		
		System.out.println(MinCoinChange.toMakeSum(coins,sum));
	}

}
