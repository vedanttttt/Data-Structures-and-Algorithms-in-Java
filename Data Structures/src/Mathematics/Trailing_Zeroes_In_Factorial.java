package Mathematics;
import java.util.*;
public class Trailing_Zeroes_In_Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res=0;
		for(int i=5;i<=n;i*=5) {
			res += n/i;
		}
		
		System.out.println(res);
	}

}
