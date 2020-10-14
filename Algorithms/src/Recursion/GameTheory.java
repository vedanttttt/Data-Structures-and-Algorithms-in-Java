package Recursion;

public class GameTheory {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {1,5,7,3,2,4};
		System.out.println(coinMax(ar,0,ar.length-1));
	}

	static int coinMax(int a[],int l,int r) {
		if(l+1==r)
			return Math.max(a[l],a[r]);
		
		return Math.max(a[l]+Math.min(coinMax(a,l+2,r),coinMax(a,l+1,r-1)),
				        a[r]+Math.min(coinMax(a,l+1,r-1),coinMax(a,l,r-2)));
	}
}
