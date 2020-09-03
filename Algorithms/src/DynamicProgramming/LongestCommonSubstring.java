package DynamicProgramming;

public class LongestCommonSubstring {

	public static int lcsubstring(String s1,String s2,int n,int m,int countOfLCS) {
		if(n==0 || m==0)
			return countOfLCS;
		
		if(s1.charAt(n-1)==s2.charAt(m-1))
			countOfLCS=lcsubstring(s1,s2,n-1,m-1,countOfLCS+1);
		
		int count1=lcsubstring(s1,s2,n-1,m,0);
		int count2=lcsubstring(s1,s2,n,m-1,0);
		
		return Math.max(countOfLCS,Math.max(count1, count2));
	}
	
	public static int lcsBottomUp(String s1,String s2,int n,int m) {
		if(n==0||m==0)
			return 0;
		
		int lcs=0;
		int[][] arr = new int[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					arr[i][j]=1+arr[i-1][j-1];
					lcs=Math.max(lcs,arr[i][j]);
				}
				else
					arr[i][j]=0;
			}
		}
		return lcs;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s1="da";
		String s2="d";
		
		System.out.println(LongestCommonSubstring.lcsubstring(s1,s2,s1.length(),s2.length(),0));
		System.out.println(LongestCommonSubstring.lcsBottomUp(s1,s2,s1.length(),s2.length()));
	}

}
