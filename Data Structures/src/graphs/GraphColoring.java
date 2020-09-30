package graphs;
import java.util.*;

class GraphColoring{
	
	static class Edge{
		int src,dest;
		
		Edge(int src,int dest){
			this.src=src;
			this.dest=dest;
		}
	};
	
	static int V=5;
	static List<List<Integer>> adj = new ArrayList<>();
	
	public GraphColoring(List<Edge> edges) {
		for(int i=0;i<edges.size();i++) {
			adj.add(i,new ArrayList<>());
		}
		
		for(Edge current: edges) {
			adj.get(current.src).add(current.dest);
			adj.get(current.dest).add(current.src);
		}
	}
	
	public static void greedyColoring() {
		int result[] = new int[V];
		
		//Initialize all vertices as unassigned
		Arrays.fill(result, -1);
		
		//Assign first color to 1st vertex
		result[0]=0;
		
		//Temporary array to store available colors,false value of available[cr] would mean that color cr is already assigned
		boolean[] available = new boolean[V];
		
		Arrays.fill(available, true);
		
		//Assigning colors to remaining v-1 vertices
		for(int u=1;u<V;u++) {
			
			//Process all adjacent vertices and flag their colors as unavailable
			List<Integer> l = adj.get(u);
			for(int i=0;i<l.size();i++) {
				if(result[l.get(i)] != -1)
					available[result[l.get(i)]]=false;
			}
			
			//Find the first available color
			int cr;
			for(cr=0;cr<V;cr++) {
				if(available[cr])
					break;
			}
			
			//Assign found color
			result[u]=cr;
			
			//Reset the values back to true for the next iteration
			Arrays.fill(available, true);
		}
		
		//printing the result
		for(int u=0;u<V;u++) {
			System.out.println("Vertex " + u + " --> Color " + result[u]);
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Edge> edges = Arrays.asList(new Edge(0,1), new Edge(0,2), 
				new Edge(1,3), new Edge(1,2), 
				new Edge(3,4), new Edge(2, 3));
		
		GraphColoring g = new GraphColoring(edges);
		greedyColoring();
	}

}
