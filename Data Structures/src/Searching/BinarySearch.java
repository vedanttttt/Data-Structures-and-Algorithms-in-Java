package Searching;

public class BinarySearch {

	public static void main(String args[]) {
		
		int[] a = {1,2,4,5,7,8,9};
	    int k=7;
	    int hi=6;
	    int li=0;
	    int mi=(li+hi)/2;
	    
	    while(li<=hi) {
	    		if(a[mi]==k) {
	    			System.out.println(mi);
	    			break;
	    		}
	    		else if(a[mi]<k) {
	    			li=mi+1;
	    		}
	    		else {
	    			hi=mi-1;
	    		}
	    		mi=(li+hi)/2;
	    }
	    if(li>hi)
	    	System.out.println("Element not found");
	}
}
