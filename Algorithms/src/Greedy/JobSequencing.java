package Greedy;
import java.util.*;

class Job{
	char id;
	int deadline,profit;
	
	public Job(char id,int deadline,int profit) {
		this.id=id;
		this.deadline=deadline;
		this.profit=profit;
	}
	
	public void printJobScheduling(List<Job> ar,int t) {
		
		int n = ar.size();
		
		//sorting jobs in decreasing order of profit
		Collections.sort(ar,(a,b)-> b.profit - a.profit);
		
		//to keep track of free time slots
		boolean[] result = new boolean[t];
		
		//to store result(sequence of jobs)
		char[] job = new char[t];
		
		for(int i=0;i<n;i++) {
			//find a free slot for this job
			for(int j=Math.min(t-1, ar.get(i).deadline-1);j>=0;j--) {
				
				if(result[j]==false) {
					result[j]=true;
					job[j]=ar.get(i).id;
					break;
				}
			}
		}
		
		//print the sequence
		for(char jb: job) {
			System.out.println(jb + " ");
		}
		System.out.println();
	}
}

public class JobSequencing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Job> arr = new ArrayList<>();
		
		arr.add(new Job('a', 2, 100));
        arr.add(new Job('b', 1, 19));
        arr.add(new Job('c', 2, 27));
        arr.add(new Job('d', 1, 25));
        arr.add(new Job('e', 3, 15));
        
        System.out.println("Following is maximum profit sequence of jobs");
        
        Job job = new Job('g', 0, 0);
        
        job.printJobScheduling(arr, 3);
	}

}
