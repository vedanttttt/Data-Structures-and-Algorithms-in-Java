package Mathematics;

public class fastPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fastPower(3,5));
		System.out.println(fastPower(3978432,5,1000000007)); // this was (3978432)^5 % 10^9+7
	}

	static int fastPower(int a,int b) {
		
		int res=1;
		
		while(b>0) {
			if((b & 1) != 0) {
				res = res*a;
			}
			a = a*a;
			b = b >> 1;  //it is same as b= b/2
		}
		
		return res;
	}
	
	static long fastPower(long a,long b,long n) {
		
		long res=1;
		
		while(b>0) {
			
			if((b&1) != 0) {
				res = (res%n * a%n)%n;
			}
			
			a = (a%n * a%n)%n;
			b = b >> 1;
		}
		
		return res;
	}
}
