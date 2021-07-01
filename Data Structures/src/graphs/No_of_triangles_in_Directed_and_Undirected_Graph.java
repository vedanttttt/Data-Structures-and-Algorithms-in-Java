package graphs;

public class No_of_triangles_in_Directed_and_Undirected_Graph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	// no. of vertices in graph	
		int V=4;
		
		// Create adjacency matrix
	       // of an undirected graph
	       int graph[][] = {{0, 1, 1, 0},
	                        {1, 0, 1, 1},
	                        {1, 1, 0, 1},
	                        {0, 1, 1, 0}
	                       };
	       
	    // Create adjacency matrix
	       // of a directed graph
	       int digraph[][] = { {0, 0, 1, 0},
	                           {1, 0, 0, 1},
	                           {0, 1, 0, 0},
	                           {0, 0, 1, 0}
	                         };
	       
	       No_of_triangles_in_Directed_and_Undirected_Graph obj = new No_of_triangles_in_Directed_and_Undirected_Graph();
	       
	       System.out.println("The Number of triangles in undirected graph : ");
	       obj.countTriangle(graph,V,false);

	       System.out.println("\n\nThe Number of triangles"+"in directed graph : ");
           obj.countTriangle(digraph,V,true);
	}
	
	public void countTriangle(int[][] graph,int v,boolean isDirected) {
		
		int count=0;
		
		// Consider every possible
	    // triplet of edges in graph
		for(int i=0;i<v;i++) {
			for(int j=0;j<v;j++) {
				for(int k=0;k<v;k++) {
					
					// Check the triplet if it
	                // satisfies the condition
					if(graph[i][j]==1 && graph[j][k]==1 && graph[k][i]==1)
						count++;
				}
			}
		}
		
		// If graph is directed , division
	    // is done by 3 else division
	    // by 6 is done
		
		//it is divided by 6 in undirected , bcoz 6 trinagles can be formed by 3 nodes as suppose 
		// nodes are 0,1,2 , edges can be  012 021 102 120 201 210
		//similarly in directed also , for more details watch video of code library
		
		if(isDirected) {
			System.out.println(count/3);
		}
		else
			System.out.println(count/6);
	}

}
