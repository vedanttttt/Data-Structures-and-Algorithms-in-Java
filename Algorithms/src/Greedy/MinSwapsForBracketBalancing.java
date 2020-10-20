package Greedy;
import java.util.*;

public class MinSwapsForBracketBalancing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(minSwaps(s));
	}
	
	public static int minSwaps(String s) {
		char[] chars = s.toCharArray();
		
		//storing total no. of left and right brackets encountered
		int countLeft=0,countRight=0;
		//storing no. of swaps required and no. of imbalancing pairs
		int swaps=0,imbalance=0;
		
		for(int i=0;i<chars.length;i++) {
			
			if(chars[i]=='[') {
				countLeft++;
				
				if(imbalance>0) {
					
					// swaps count is last swap count + total  
                    // number imbalanced brackets 
                    swaps += imbalance;  
                    // imbalance decremented by 1 as it solved 
                    // only one imbalance of Left and Right 
                    imbalance--;
				}
			}
			else if(chars[i] == ']') {
				countRight++;
				
				// imbalance is reset to current difference  
                // between Left and Right brackets 
                imbalance = (countRight-countLeft); 
			}
		}
		
		return swaps;
	}

}
