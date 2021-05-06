package Aditya_Verma_DP;

public class Knapsack {

	static int profit=0;
	
	public static void find(int[] wt,int[] val,int W,int curr,int ind) {
		if(W==0) {
			profit = Math.max(profit, curr);
			return;
		}
		
		for(int i=ind;i<4;i++) {
			if()
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] wt = {1,3,4,5};
		int[] val = {1,4,5,7};
		int W = 7;
		
		find(wt,val,W,0,0);
	}

}
