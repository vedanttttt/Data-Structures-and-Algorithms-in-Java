package Sorting;

public class BubbleStringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] a = {"vedant","prateek","deepesh","amit","veronica"};
		int n = a.length;
		for(int i=0;i<n;i++) {
			boolean sorted=true;
			for(int j=0;j<n-1-i;j++) {
				if(a[j].compareTo(a[j+1])>0){
                    String temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                    
                    sorted=false;
				}
			}
			if(sorted)
				break;
		}
		
		for(String s:a)
			System.out.println(s);
	}

}
