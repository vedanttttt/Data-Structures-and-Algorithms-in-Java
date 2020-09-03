package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class SubsetSumProblem {

	private static boolean isSubsetExists(int[] arr, int sum) {
		// TODO Auto-generated method stub
		if(arr.length==0)
			return false;
		
		boolean[][] mat = new boolean[arr.length][sum+1];
		for(int i=0;i<arr.length;i++) {
			mat[i][0]=true;
		}
		for(int j=0;j<=sum;j++) {
			if(j==arr[0])
				mat[0][j]=true;
		}
		for(int i=1;i<arr.length;i++) {
			for(int j=1;j<=sum;j++) {
				if(mat[i-1][j])
					mat[i][j]=true;
				else {
					if(j>=arr[i])
						mat[i][j]=mat[i-1][j-arr[i]];
				}
			}
		}
		
		return mat[arr.length-1][sum];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	   int[] arr= {1,2,3,5};
	   int sum=7;
	   System.out.println(SubsetSumProblem.isSubsetExists(arr,sum));
	}

	

}
