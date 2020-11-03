package Greedy;

public class FittingShelves {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int wall=29,m=3,n=9;
		minSpacePreferLarge(wall,m,n);
	}
	
	public static void minSpacePreferLarge(int wall,int m,int n) {
		
		//Assuming m is always lesser than n
		//initializing output variables
		int num_m=0,num_n=0,min_empty=wall;
		
		//p and q are no of shelves of length m and n
		//rem is the empty space
		int p=0,q=0,rem;
		
		while(wall >= n) {
			//place as many shelves of length m in the remaining part
			p = wall/m;
			rem = wall %m;
			
			//update output variables if curr min_empty<=overall empty
			if(rem <= min_empty) {
				num_m=p;
				num_n=q;
				min_empty=rem;
			}
			
			//place one more shelf of length n
			q += 1;
			wall = wall - n;
		}
		System.out.println(num_m + " " + num_n + " " + min_empty);
	}
}
