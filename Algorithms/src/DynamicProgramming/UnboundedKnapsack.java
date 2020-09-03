package DynamicProgramming;

public class UnboundedKnapsack {

	public static int getMaxProfit(int[] wt,int[] pr,int capacity) {
		if(wt.length==0 || pr.length==0 || capacity<=0)
			return 0;
		
		int noOfWeights=wt.length;
		int[][] arr= new int[noOfWeights][capacity+1];
		
		for(int i=0;i<noOfWeights;i++) {
			for(int j=1;j<=capacity;j++) {

				int includingProfit=0;
				int excludingProfit=0;
				
				if(wt[i]<=j)
					includingProfit=pr[i]+arr[i][j-wt[i]];
				if(i>0)
					excludingProfit=arr[i-1][j];
				
				arr[i][j]=Math.max(includingProfit, excludingProfit);
			}
		}
		
		return arr[noOfWeights-1][capacity];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] wt= {1,2,3,5};
		int[] pr= {1,4,7,10};
		
		int capacity=8;
		System.out.println(UnboundedKnapsack.getMaxProfit(wt,pr,capacity));
	}

}
