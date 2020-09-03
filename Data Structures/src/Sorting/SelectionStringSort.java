package Sorting;

public class SelectionStringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] a = {"vedant","prateek","deepesh","amit","veronica"};
		//int[] a= {5,4,3,2,1};
		int n = a.length;
		
		for(int i=0;i<n-1;i++) {
			int min=i;
			for(int j=i;j<n;j++) {
				if(a[j].compareTo(a[min])<0)
				   min=j;
			}
			String temp=a[i];
			a[i]=a[min];
			a[min]=temp;
		}
		
		for(String e:a)
			System.out.println(e);
	}

}
