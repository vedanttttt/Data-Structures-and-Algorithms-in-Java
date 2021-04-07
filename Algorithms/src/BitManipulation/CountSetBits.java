//Write a function that takes an unsigned integer and returns the number of 1 bits it has.

package BitManipulation;

public class CountSetBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(numSetBits(13));
	}
		public static int numSetBits(long a) {
		    int count=0;
		    while(a!=0){
		        a = a & (a-1);
		        count++;
		    }
		    
		    return count;
		}

}
