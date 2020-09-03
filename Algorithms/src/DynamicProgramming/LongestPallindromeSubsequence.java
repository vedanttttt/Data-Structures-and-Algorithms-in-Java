package DynamicProgramming;

public class LongestPallindromeSubsequence {

	public static int lps(String s,int start,int end) {
		if(start>end)
			return 0;
		if(start==end)
			return 1;
		if(s.charAt(start)==s.charAt(end))
			return 2+lps(s,start+1,end-1);
		
		return Math.max(lps(s,start+1,end),lps(s,start,end-1));
	}
	
	public static int lpsTopDown(String s,int start,int end,Integer[][] arr) {
		if(start>end)
			return 0;
		if(start==end)
			return 1;
		if(arr[start][end]==null) {
			if(s.charAt(start)==s.charAt(end))
				arr[start][end]= 2+lpsTopDown(s,start+1,end-1,arr);
			else
			    arr[start][end]= Math.max(lpsTopDown(s,start+1,end,arr),lpsTopDown(s,start,end-1,arr));
		}
		return arr[start][end];
	}
	
	public static int lpsBottomUp(String s,int n) {
		int[][] arr = new int[n][n];
		
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				if(s.charAt(i)==s.charAt(j))
					arr[i][j]=2+arr[i+1][j-1];
				else
					arr[i][j]=Math.max(arr[i+1][j],arr[i][j-1]);
			}
		}
		return arr[0][n-1];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="aba";
		System.out.println(LongestPallindromeSubsequence.lps(s,0,s.length()-1));
		
		Integer[][] arr = new Integer[s.length()][s.length()];
		System.out.println(LongestPallindromeSubsequence.lpsTopDown(s,0,s.length()-1,arr));
		
		System.out.println(LongestPallindromeSubsequence.lpsBottomUp(s,s.length()));
	}

}
