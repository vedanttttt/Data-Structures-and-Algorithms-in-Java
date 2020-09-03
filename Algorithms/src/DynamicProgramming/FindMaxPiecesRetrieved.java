package DynamicProgramming;

import java.util.Arrays;

public class FindMaxPiecesRetrieved {

	public static int getMaxPieces(int[] pieces,int length) {
		if(pieces.length==0 || length<=0)
			return 0;
		
		int[][] dp = new int[pieces.length][length+1];

        for(int i=0;i<pieces.length-1;i++) {
        	for(int j=0;j<length;j++) {
        		dp[i][j]=-1;
        	}
        }
		
		for(int i=0;i<pieces.length;i++) {
			dp[i][0]=0;
		}
		 
		for(int i=0;i<pieces.length;i++) {
			for(int j=1;j<=length;j++) {
				
				int including =-1;
				int excluding =-1;
				
				if(pieces[i]<=j && dp[i][j-pieces[i]]!=-1)
					including = 1+dp[i][j-pieces[i]];
				if(i>0)
					excluding = dp[i-1][j];
				 
				dp[i][j]=Math.max(including, excluding);
			}
		}
		return dp[pieces.length-1][length];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] pieces = {4,2,3,5};
		int pieceLength=7;
		System.out.println(FindMaxPiecesRetrieved.getMaxPieces(pieces,pieceLength));
	}

}
