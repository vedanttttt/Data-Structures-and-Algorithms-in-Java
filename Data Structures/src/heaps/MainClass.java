package heaps;

import java.util.*;
public class MainClass {

  public static void minHeap(int[] arr) {
	  PriorityQueue<Integer> heap = new PriorityQueue<>();
		
		for(int i=0;i<arr.length;i++) {
			heap.add(arr[i]);
			System.out.print(heap.peek()+" ");
		}
		System.out.println();
		
		for(int i=0;i<arr.length;i++) {
			heap.poll();
			System.out.print(heap.peek()+" ");
		}
		System.out.println();
		
  }
  
  public static void maxHeap(int[] arr) {
	  PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
	  
	  for(int i=0;i<arr.length;i++) {
			heap.add(arr[i]);
			System.out.print(heap.peek()+" ");
		}
		System.out.println();
		
		for(int i=0;i<arr.length;i++) {
			heap.poll();
			System.out.print(heap.peek()+" ");
		}
		System.out.println();
	  
  }
  
  public static int kthlargest(int k,int[] arr) {
	 // MainClass.maxHeap(arr);
	  PriorityQueue<Integer> heap = new PriorityQueue<>();
	  for(int i=0;i<arr.length;i++) {
		  if(i<k) {
			  heap.add(arr[i]);
		  }
		  else {
			  if(heap.peek()<arr[i]) {
				  heap.poll();
				  heap.add(arr[i]);
			  }
		  }
	  } 
	    return heap.peek();
	   }
  
  public static int kthlargeststream(int k,int num) {
	  PriorityQueue<Integer> heap = new PriorityQueue<>(); // this code is not correct as it will make new heap for every number we enter.
	  if(heap.size()<k) {
		  heap.add(num);
		  return heap.size()==k ? heap.peek() : -1;
	  }
		  if(num>heap.peek()) {
			  heap.poll();
			  heap.add(num);
		  }
	  
	  return heap.peek();
  }
  
  public static List<Integer> topkfrequent(int[] arr,int k) {
	Map<Integer,Integer> map = new HashMap<>();
	for(int i=0;i<arr.length;i++) {
		map.put(arr[i],map.getOrDefault(arr[i],0)+1);
	}
	
	PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(
			(n1,n2)-> n2.getValue() - n1.getValue());   // for minHeap do n1.getvalue() - n2.getValue()
	
	maxHeap.addAll(map.entrySet());
	
	List<Integer> list = new ArrayList<>();
	
	for(int i=0;i<k;i++) {
		list.add(maxHeap.poll().getKey());
	}
	return list;
	  
  }
  
 
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,7,11,5,2,13,1,45};
		int[] arr1 = {8,10,7,8,11,30,11,8,38,11,2,45,2,8};
		//MainClass.minHeap(arr);
		//MainClass.maxHeap(arr);
		//System.out.println();
		//System.out.println(MainClass.kthlargest(1,arr));
		/*for(int i=0;i<arr.length;i++) {
			System.out.println(MainClass.kthlargeststream(3,arr[i]));
		}*/
		System.out.println(MainClass.topkfrequent(arr1,3));
		
	}

}
