package BigIntegers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

public class BigDecimals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s ="123";
		BigInteger r = new BigInteger(s);
		System.out.println(r);
		Scanner sc = new Scanner(System.in);
		BigDecimal num = new BigDecimal("1234567890");
		BigDecimal num1,num2;
		num1=sc.nextBigDecimal();
		num2 = sc.nextBigDecimal();
		System.out.println(num1.add(num2));
		System.out.println(num1.subtract(num2));
		System.out.println(num1.multiply(num2));
		System.out.println(num1.divide(num2, 4, RoundingMode.CEILING));
	}

}
