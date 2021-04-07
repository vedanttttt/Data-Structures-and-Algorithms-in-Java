package Greedy;

public class Array_element_moved_by_k_using_single_moves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {3,1,2};
		int k = 2;
		System.out.println(winner(ar,ar.length,k));
	}
	
	public static int winner(int[] ar,int n,int k) {
		
		// if the number of steps is more then 
        // n-1, 
        if (k >= n - 1) 
            return n; 
		
		int winner = ar[0];
		int count = 0;
		
		for(int i=1;i<n;i++) {
			if(ar[i]>winner) {
				winner=ar[i];
				count=1;
			}
			else {
				count++;
			}
			if(count==k) {
				return winner;
			}
		}
		
		// Maximum element will be winner 
        // because we move smaller element 
        // at end and repeat the process. 
		return winner;
	}

}
