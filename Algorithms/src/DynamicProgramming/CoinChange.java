package DynamicProgramming;

public class CoinChange {

	public static int totalWays(int[] coins,int sum) {
		if(coins.length==0 || sum<=0)
			return 0;
		
		int noOfCoins=coins.length;
		int[][] arr = new int[noOfCoins][sum+1];
		
		for(int i=0;i<arr.length;i++) {
			arr[i][0]=1;
		}
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<arr[0].length;j++) {
				
				int includingCurrentCoin=0;
				int excludingCurrentCoin=0;
				
				if(i>0)
					excludingCurrentCoin=arr[i-1][j];
				if(j>=coins[i])
					includingCurrentCoin=arr[i][j-coins[i]];
				
				arr[i][j]=excludingCurrentCoin+includingCurrentCoin;
			}
		}
		return arr[arr.length-1][sum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] coins= {2,4,5};
		int sum=1;
		System.out.println(CoinChange.totalWays(coins,sum));
	}

}
