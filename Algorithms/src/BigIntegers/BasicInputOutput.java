package BigIntegers;

import java.math.BigInteger;
import java.util.*;

public class BasicInputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Scanner sc = new Scanner(System.in);
     BigInteger num1 = sc.nextBigInteger();
     BigInteger num2 = sc.nextBigInteger();
     
  /*  if(num1.compareTo(new BigInteger("90"))>0)
    	 System.out.println("good");
	
    while(!num1.equals(new BigInteger("0"))) {
    	System.out.println("fine"+num1);
    	num1= num1.subtract(new BigInteger("1"));
    }
    
    
    for(BigInteger x = BigInteger.ONE;x.compareTo(new BigInteger("5"))<=0;x=x.add(new BigInteger("1"))) {
    	System.out.println(x);
    }*/
     
   /*  BigInteger f = BigInteger.ONE;
     for(BigInteger i=num1;i.compareTo(BigInteger.ONE)>=0;i=i.subtract(BigInteger.ONE)) {
    	 f=f.multiply(i);
     }
     System.out.println(f);
     */
     
      BigInteger gcd = num1.gcd(num2);
      System.out.println(gcd);
     
      Boolean isprime = num1.isProbablePrime(1);
      System.out.println(isprime);
	}
}
