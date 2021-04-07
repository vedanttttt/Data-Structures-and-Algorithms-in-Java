package BitManipulation;

public class Bit_Masking {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//finding ith bit
		int n = 1110;
		int mask = n>>3;
		System.out.println(mask);
		String s = Integer.toBinaryString(mask);
		System.out.println(s);
		System.out.println(1&01);
		System.out.println(2 & 1);
	}

}
