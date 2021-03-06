package Recursion;

import java.util.Arrays;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=18;
		int[] ar = {7,5,1};
		System.out.println(minCoins(n,ar));
		
		int dp[] = new int[n+1];
		Arrays.fill(dp,-1);
		dp[0]=0;
		int ans=minCoinsDp(n,ar,dp);
		System.out.println(ans);
	}
	
	public static int minCoins(int n,int[] a) {
		
		if(n==0)
			return 0;
		
		int ans = Integer.MAX_VALUE;
		
		for(int i=0;i<a.length;i++) {
			if(n-a[i]>=0) {
				int subAns = minCoins(n-a[i],a);
			
				if(subAns!=Integer.MAX_VALUE && subAns+1<ans)
				ans=subAns+1;
			}
		}
		
		return ans;
	}
	
	public static int minCoinsDp(int n,int[] a,int[] dp) {
		if(n==0)
			return 0;
		
		int ans = Integer.MAX_VALUE;
		for(int i=0;i<a.length;i++) {
			if(n-a[i]>=0) {
				int subAns=0;
				if(dp[n-a[i]]!= -1)
					subAns=dp[n-a[i]];
				else
					subAns=minCoinsDp(n-a[i],a,dp);
				
				if(subAns!= Integer.MAX_VALUE && subAns+1<ans)
					ans=subAns+1;
			}
		}
		dp[n]=ans;
		return ans;
	}

}
