package Greedy;
import java.util.*;
public class MaximizeArraySumAfterKNegations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-2,0,5,-1,2};
		int k = 4;
		System.out.println(maxSum(arr,k));
	}
	
	public static int maxSum(int[] a,int k) {
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int e:a)
			pq.add(e);
		
		//do k negations by removing a minimum element k times
		while(k-- >0) {
			
			//retrieve min element
			int temp = pq.poll();
			
			//modifying minimum element and adding back to queue
			temp *= -1;
			pq.add(temp);
		}
		
		int sum=0;
		for(int e: pq)
			sum += e;
		return sum;
	}

}
