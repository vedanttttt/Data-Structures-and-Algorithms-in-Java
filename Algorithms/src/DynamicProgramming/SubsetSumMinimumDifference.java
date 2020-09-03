package DynamicProgramming;

public class SubsetSumMinimumDifference {

	public static int getMinDifference(int[] ar) {
		if(ar.length==0)
			return -1;
		int sumOfArray=0;
		for(int i=0;i<ar.length;i++) {
			sumOfArray+=ar[i];
		}
		int sum=sumOfArray/2;
		
		boolean[][] mat = new boolean[ar.length][sum+1];
		for(int i=0;i<ar.length;i++) {
			mat[i][0]=true;
		}
		for(int j=0;j<=sum;j++) {
			if(ar[0]==j)
				mat[0][j]=true;
		}
		
		for(int i=1;i<ar.length;i++) {
			for(int j=1;j<=sum;j++) {
				if(mat[i-1][j])
					mat[i][j]=true;
				else {
					if(j>=ar[i])
						mat[i][j]=mat[i-1][j-ar[i]];
				}
			}
		}
		
		int lastRow=ar.length-1;
		int firstPartitionSum=-1;
		
		for(int j=sum;j>=0;j--) {
			if(mat[lastRow][j]) {
				firstPartitionSum=j;
				break;
			}
		}
		int secondPartitionSum=sumOfArray-firstPartitionSum;
		
		return Math.abs(firstPartitionSum-secondPartitionSum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {1,2,3,5,13};
		System.out.println(SubsetSumMinimumDifference.getMinDifference(arr));
	}

}
