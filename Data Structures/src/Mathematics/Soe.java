package Mathematics;

import java.util.Arrays;

public class Soe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] isPrime = sieveOfEratoSthenes(20);
		for(int i=0;i<=20;i++) {
			System.out.println(i + " "+isPrime[i]);
		}
	}
	
	static boolean[] sieveOfEratoSthenes(int n) {
		
		boolean[] isPrime = new boolean[n+1];
		Arrays.fill(isPrime, true);
		
		isPrime[0]=false;
		isPrime[1]=false;
		
		for(int i=2;i*i<=n;i++) { // i*i<=n means i will go till squareroot of n
			
			for(int j=2*i;j<=n;j += i) {
				isPrime[j] = false;
			}
		}
		
		return isPrime;
	}

}
