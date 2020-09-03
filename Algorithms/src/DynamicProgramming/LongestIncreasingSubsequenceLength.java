package DynamicProgramming;

public class LongestIncreasingSubsequenceLength {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a= {7,1,4,8,11,2,14,3};
		
		System.out.println(LongestIncreasingSubsequenceLength.lisLength(a));
	}

	public static int lisLength(int[] a) {
		int[] lis=new int[a.length];
		
	for(int i=0;i<lis.length;i++) {
		lis[i]=1;
	}
		
		int  maxlisLength=1;
		
		for(int i=1;i<lis.length;i++) {
			for(int j=0;j<i;j++) {
				if((a[i]>a[j]) && ((1+lis[j])>lis[i])) {
					lis[i]=lis[j]+1;
					}
			}
			maxlisLength=Math.max(maxlisLength, lis[i]);
		}
		
		return maxlisLength;
	}
}
