package Sorting;

public class MergeSort {

	int[] array;
	int[] tempMergeArr;
	int length;
	
	public static void main(String args[]) {
		
		int a[]= {48,36,13,52,19,94,21};
		MergeSort ms = new MergeSort();
		ms.sort(a);
		
		for(int e:a)
			System.out.println(e);
	}

    public void sort(int[] a) {
    	this.array=a;
    	this.length=a.length;
    	this.tempMergeArr=new int[length];
        divideArray(0,length-1);
    }
    
    public void divideArray(int lowerIndex,int higherIndex) {
    	if(lowerIndex<higherIndex) {
    		int middle = lowerIndex+(higherIndex-lowerIndex)/2;
    		//It will sort left side of array
    		divideArray(lowerIndex,middle);
    		//It will sort right side of array
    		divideArray(middle+1,higherIndex);
    		
    		mergeArray(lowerIndex,middle,higherIndex);
    	}
    }
    
    public void mergeArray(int lowerIndex,int middle,int higherIndex) {
    	for(int i=lowerIndex;i<=higherIndex;i++) {
    		tempMergeArr[i]=array[i];
    	}
    	
    	int i=lowerIndex;
    	int j= middle+1;
    	int k = lowerIndex;
    	while(i<=middle && j<=higherIndex) {
    		if(tempMergeArr[i]<=tempMergeArr[j]) {
    			array[k]=tempMergeArr[i];
    			i++;
    		}
    		else {
    			array[k]=tempMergeArr[j];
    			j++;
    		}
    		k++;
    	}
    	while(i<=middle) {
    		array[k]=tempMergeArr[i];
    		k++;
    		i++;
    	}
    }
}
