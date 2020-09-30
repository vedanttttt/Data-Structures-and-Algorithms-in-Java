package graphs;
import java.util.*;
public class SnakeandLadder {

	static class Qentry{
		int dist;
		int v;
		
		Qentry(int a,int b){
			this.v =a;
			this.dist=b;
		}
	}
	
	public static int getMinDiceThrows(int[] move,int n) {
		Qentry qe = new Qentry(0,0);
		boolean[] visited = new boolean[n];
		Queue<Qentry> q = new LinkedList<>();
		q.add(qe);
		visited[0]=true;
		
		while(!q.isEmpty()) {
			qe = q.poll();
			int v = qe.v;
			if(v==n-1) {
				break;
			}
			
			for(int i=v+1;i<=(v+6) && i<n;i++) {
				if(!visited[i]) {
					visited[i]=true;
					
					int ver = 0;
					if(move[i] != -1)
						ver = move[i];
					else
						ver = i;
					
					q.add(new Qentry(ver,qe.dist+1));
				}
			}
		}
		return qe.dist;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 30; 
        int moves[] = new int[N]; 
        for (int i = 0; i < N; i++) 
            moves[i] = -1; 
  
        // Ladders 
        moves[2] = 21; 
        moves[4] = 7; 
        moves[10] = 25; 
        moves[19] = 28; 
  
        // Snakes 
        moves[26] = 0; 
        moves[20] = 8; 
        moves[16] = 3; 
        moves[18] = 6; 
  
        System.out.println("Min Dice throws required is " +  
                          getMinDiceThrows(moves, N)); 
	}

}
