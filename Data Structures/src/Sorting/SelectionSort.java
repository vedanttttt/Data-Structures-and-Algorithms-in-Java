package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {3,1,-2,7,4,0};
		int n = a.length;
		
		int flag=0;
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i;j<n;j++) {
			if(a[j]<a[min]) {
				min=j;
			}
			}
			flag=a[i];
			a[i]=a[min];
			a[min]=flag;
		}
		
		for(int r:a)
			System.out.println(r);
	}

}
