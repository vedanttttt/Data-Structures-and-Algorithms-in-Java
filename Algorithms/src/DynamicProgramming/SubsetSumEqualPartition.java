package DynamicProgramming;

public class SubsetSumEqualPartition {

	public static boolean ifExists(int[] a) {
		if(a.length==0)
			return false;
		int sumOfArray=0;
		for(int i=0;i<a.length;i++) {
			sumOfArray+=a[i];
		}
		if(sumOfArray%2!=0)
			return false;
		
		int sum=sumOfArray/2;
		//Do the previous code then
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr= {1,2,3,5,7};
		System.out.println(SubsetSumEqualPartition.ifExists(arr));
	}

}
