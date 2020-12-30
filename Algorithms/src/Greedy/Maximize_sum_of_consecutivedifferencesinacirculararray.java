package Greedy;
import java.util.*;
public class Maximize_sum_of_consecutivedifferencesinacirculararray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] ar = new int[n];
		for(int i=0;i<n;i++) {
			ar[i] = sc.nextInt();
		}
		
		Arrays.sort(ar);
		int res[] = new int[n];
		int m=0;
		int l = 0,h=n-1;
		while(l<h) {
			res[m++]=ar[l++];
			res[m++]=ar[h--];
		}
		if(l==h)
			res[m]=ar[l];
		
		int ans=0;
		for(int i=1;i<n;i++) {
			ans += Math.abs(res[i]-res[i-1]);
		}
		ans += res[n-1]-res[0];
		
		System.out.println(ans);
	}

}
