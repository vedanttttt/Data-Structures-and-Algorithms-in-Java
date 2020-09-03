//Min jumps to reach nth stair using 1,2 or 3 steps.

package DynamicProgramming;

public class MinStair {

	public int minSteps(int n) {
		if(n==0)
			return 0;
		if(n==1 || n==2 || n==3)
			return 1;
		
		return 1 +  Math.min(Math.min(minSteps(n-1),minSteps(n-2)),minSteps(n-3));
		 
	}
	
	public int minStepsTopDown(int[] arr,int n) {
		if(n==0)
			return 0;
		else if(n==1 || n==2 || n==3)
			return 1;
		if(arr[n]==0) {
			arr[n] =1+ Math.min(Math.min(minStepsTopDown(arr,n-1),minStepsTopDown(arr,n-2)),minStepsTopDown(arr,n-3));
		}
		return arr[n];
	}
	
	public int minStepsBottomUp(int n) {
		int arr[] = new int[n+1];
        arr[0]=0;
        arr[1]=1;
        arr[2]=1;
        for(int i=3;i<=n;i++) {
          arr[i]=1+ Math.min(Math.min(arr[i-1],arr[i-2]),arr[i-3]);
        }
        return arr[n];
	}
	
	public int minStepsBottomUpBetter(int n) {
       int a=0;
       int b=1;
       int c=1;
       int d=0;
       for(int i=3;i<=n;i++) {
    	    d = 1+Math.min(Math.min(a,b),c);
    	    a=b;
    	    b=c;
    	    c=d;
       }
       return d;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MinStair ms = new MinStair();
        int n=7;
        System.out.println(ms.minSteps(n));
		
        int[] arr = new int[n+1];
        System.out.println(ms.minStepsTopDown(arr, n));
        
        System.out.println(ms.minStepsBottomUp(n));
        System.out.println(ms.minStepsBottomUpBetter(n));
	}

}
