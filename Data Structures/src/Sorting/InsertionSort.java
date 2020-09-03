package Sorting;


public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = {5,1,6,2,4,3};
		int n = a.length;
		
		for(int i=1;i<n;i++) {
			int temp=a[i];
			int j=i;
			while(j>0 && a[j-1]>temp) {
                 a[j]=a[j-1];
                 j--;
			}
			a[j]=temp;
		}
		
		for(int e:a)
			System.out.println(e);
	}

}

