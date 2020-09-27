package graphs;
import java.util.*;

class Gp{
	
	class Edge{
		int src,dest,weight;
		Edge(){
			src = dest = weight=0;
		}
	}
	
	int V,E;
	Edge edge[];
	
	Gp(int v,int e){
		V=v;
		E=e;
		edge = new Edge[e];
		for(int i=0;i<e;i++) {
			edge[i] = new Edge();
		}
	}
	
	void bellmanFord(Gp graph,int src) {
		int V = graph.V;
		int E = graph.E;
		int[] dist = new int[V];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[src]=0;
		
		//Relaxing all the edges V-1 times
		for(int i=1;i<V;i++) {
			for(int j=0;j<E;j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}
		
		//Checking for negative weight cycles
		for(int j=0;j<E;j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if(dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		printArray(dist,V);
	}
	
	void printArray(int[] dist,int V) {
		System.out.println("Vertex distance from source");
		for(int i=0;i<V;i++) {
			System.out.println(i + "\t\t" + dist[i]);
		}
	}
}

public class Bellman_Ford {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V=5;
		int E=8;
		
		Gp graph = new Gp(V, E); 
		  
        // add edge 0-1  
        graph.edge[0].src = 0; 
        graph.edge[0].dest = 1; 
        graph.edge[0].weight = -1; 
  
        // add edge 0-2  
        graph.edge[1].src = 0; 
        graph.edge[1].dest = 2; 
        graph.edge[1].weight = 4; 
  
        // add edge 1-2  
        graph.edge[2].src = 1; 
        graph.edge[2].dest = 2; 
        graph.edge[2].weight = 3; 
  
        // add edge 1-3  
        graph.edge[3].src = 1; 
        graph.edge[3].dest = 3; 
        graph.edge[3].weight = 2; 
  
        // add edge 1-4  
        graph.edge[4].src = 1; 
        graph.edge[4].dest = 4; 
        graph.edge[4].weight = 2; 
  
        // add edge 3-2  
        graph.edge[5].src = 3; 
        graph.edge[5].dest = 2; 
        graph.edge[5].weight = 5; 
  
        // add edge 3-1  
        graph.edge[6].src = 3; 
        graph.edge[6].dest = 1; 
        graph.edge[6].weight = 1; 
  
        // add edge 4-3  
        graph.edge[7].src = 4; 
        graph.edge[7].dest = 3; 
        graph.edge[7].weight = -3; 
  
        graph.bellmanFord(graph, 0); 
	}

}
