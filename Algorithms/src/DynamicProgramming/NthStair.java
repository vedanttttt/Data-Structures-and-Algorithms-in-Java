//Total no. of ways to reach nth Stair using step 1,2 or 3.

package DynamicProgramming;

public class NthStair {

	public int totalWays(int n) {
		if(n==0)
			return 1;
		else if(n==1)
			return 1;
		if(n==2)
			return 2;
		
		return totalWays(n-1) + totalWays(n-2) + totalWays(n-3); 
	}
	
	public int totalWaysTopDown(int[] a,int n) {
		if(n==0)
			return 1;
		if(n==1)
			return 1;
		if(n==2)
			return 2;
		
		if(a[n]==0) {
			a[n]= totalWaysTopDown(a,n-1) + totalWaysTopDown(a,n-2) + totalWaysTopDown(a,n-3);
		}
		return a[n];
	}
	
	public int totalWaysBottomUp(int n) {
		int[] a = new int[n+1];
		a[0]=1;
		a[1]=1;
		a[2]=2;
		for(int i=3;i<=n;i++) {
			a[i]=a[i-1]+a[i-2]+a[i-3];
		}
		return a[n];
	}
	
	public int totalWaysBottomUpBetter(int n) {
		int a=1;
		int b=1;
		int c=2;
		int d=0;
		for(int i=3;i<=n;i++) {
			d=a+b+c;
			a=b;
			b=c;
			c=d;
		}
		return c;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        NthStair s = new NthStair();
        System.out.println(s.totalWays(4));
        int[] arr = new int[5];
        System.out.println(s.totalWaysTopDown(arr, 4));
        System.out.println(s.totalWaysBottomUp(4));
        System.out.println(s.totalWaysBottomUpBetter(4));
	}

}
