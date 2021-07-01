package graphs;

//It is also called all pair shortest path problem

public class Floyd_Warshall {

	final static int INF = 99999,V=4;
	
	void fw(int[][] graph) {
		int[][] dist = new int[V][V];
		int i,j,k;
		
		for(i=0;i<V;i++) {
			for(j=0;j<V;j++) {
				dist[i][j]=graph[i][j];
			}
		}
		
		for(k=0;k<V;k++) {
			for(i=0;i<V;i++) {
				for(j=0;j<V;j++) {
					if(dist[i][j]> dist[i][k] + dist[k][j])
						dist[i][j]= dist[i][k] + dist[k][j];
				}
			}
		}
		
		printSolution(dist);
	}
	
	void printSolution(int[][] dist) {
		System.out.println("The following matrix shows the shortest "+ 
                "distances between every pair of vertices");
		
		for(int i=0;i<V;i++) {
			for(int j=0;j<V;j++) {
				if(dist[i][j]==INF)
					System.out.print("INF ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int graph[][] = { {0,   5,  INF, 10}, 
                {INF, 0,   3, INF}, 
                {INF, INF, 0,   1}, 
                {INF, INF, INF, 0} 
              }; 
		Floyd_Warshall fw = new Floyd_Warshall();
		fw.fw(graph);
	}

}
