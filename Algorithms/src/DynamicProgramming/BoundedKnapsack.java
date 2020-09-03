package DynamicProgramming;

public class BoundedKnapsack {

	public static int getMaxProfit(int[] wt,int[] pr,int capacity) {
		if(wt.length==0 || pr.length==0 || capacity<=0)
			return 0;
		
		int[][] arr = new int[wt.length][capacity+1];
		
		for(int i=0;i<=wt.length-1;i++) {
			for(int w=0;w<=capacity;w++) {
				if(i==0 || w==0)
					arr[i][w]=0;
				else if(wt[i]<=w)
					arr[i][w]=Math.max(arr[i-1][w],arr[i-1][w-wt[i]]+pr[i]);
				else
					arr[i][w]=arr[i-1][w];
			}
		}
		
		return arr[wt.length-1][capacity];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] wt= {0,1,2,3,5};
		int[] pr= {0,1,4,7,10};
		int capacity=8;
		
		System.out.println(BoundedKnapsack.getMaxProfit(wt,pr,capacity));
	}

}
