package DynamicProgramming;

public class LongestPallindromicSubstring {

	public static int lpSubstring(String str,int start,int end) {
		if(start>end)
			return 0;
		if(start==end)
			return 1;
		
		if(str.charAt(start)==str.charAt(end)) {
			int lpsRemainingString=end-start-1;
			
			if(lpsRemainingString==lpSubstring(str,start+1,end-1)) {
				return 2+lpsRemainingString;
			}
		}
		
		return Math.max(lpSubstring(str,start+1,end),lpSubstring(str,start,end-1));
	}
	
	private static int lpsTopDown(String s, int start, int end, Integer[][] arr) {
		if(start==end)
			return 1;
		if(start>end)
			return 0;
		if(arr[start][end]==null) {
			if(s.charAt(start)==s.charAt(end)) {
				int lpsRemainingString=end-start-1;
				
				if(lpsRemainingString==lpsTopDown(s,start+1,end-1,arr))
					arr[start][end]= 2+lpsRemainingString;
			}
			else
			 arr[start][end]=Math.max(lpsTopDown(s,start+1,end,arr),lpsTopDown(s,start,end-1,arr));
		}
		
		return arr[start][end];
	}
	
	public static int lpsBottomUp(String s,int n) {
		if(s=="")
			return 0;
		
		boolean[][] arr = new boolean[n][n];
		int maxLps=1;
		
		for(int i=0;i<s.length();i++) {
			arr[i][i]=true;
		}
		
		for(int i=n-2;i>=0;i--) {
			for(int j=i+1;j<n;j++) {
				
				if(s.charAt(i)==s.charAt(j)) {
					if(arr[i+1][j-1] || j-i==1) {
						arr[i][j]=true;
						maxLps=Math.max(maxLps,j-i+1);
					}
				}
			}
		}
		return maxLps;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s="abdba";
		System.out.println(LongestPallindromicSubstring.lpSubstring(s,0,s.length()-1));
		
		Integer[][] arr = new Integer[s.length()][s.length()];
		System.out.println(LongestPallindromicSubstring.lpsTopDown(s,0,s.length()-1,arr));
		
		System.out.println(LongestPallindromicSubstring.lpsBottomUp(s,s.length()));
	}

	

}
