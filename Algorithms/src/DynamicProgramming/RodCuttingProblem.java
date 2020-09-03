package DynamicProgramming;

public class RodCuttingProblem {

	public static int getMaxProfit(int[] pieces,int[] pr,int length) {
		if(pieces.length==0 || pr.length==0 || length<=0)
			return 0;
		
		int[][] arr = new int[pieces.length][length+1];
		
		for(int i=0;i<arr.length;i++) {
			for(int j=1;j<=length;j++) {
				
				int including=0;
				int excluding=0;
				
				if(i>0)
					excluding=arr[i-1][j];
				if(pieces[i]<=j)
					including= pr[i]+arr[i][j-pieces[i]];
				
				arr[i][j]=Math.max(including, excluding);
			}
		}
		return arr[pieces.length-1][length];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pieces= {1,2,3,4,5};
		int[] profit= {3,5,10,11,15};
		
		int rodlength=5;
		System.out.println(RodCuttingProblem.getMaxProfit(pieces,profit,rodlength));
	}

}
