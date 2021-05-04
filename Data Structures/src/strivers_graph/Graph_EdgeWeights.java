package strivers_graph;

import java.util.*;

class Pair{
	private int V;
	private int weight;
	
	Pair(int v,int w){
		this.V=v;
		this.weight=w;
	}
	
	int getV() {
		return this.V;
	}
	
	int getWeight() {
		return this.weight;
	}
}

public class Graph_EdgeWeights {
	
	public void shortestPath_DAG_BFS(int src,List<List<Pair>> adj,int n) {
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[n];
		
		for(int i=0;i<n;i++) {
			if(!visited[i])
				topoSort_forShortestpath(i,adj,visited,stack);
		}
		
		int[] dist = new int[n];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src]=0;
		
		while(!stack.isEmpty()) {
			
			int node = stack.pop();
			
			if(dist[node] != Integer.MAX_VALUE) {
				
				for(Pair it : adj.get(node)) {
					if(dist[node]+it.getWeight() < dist[it.getV()]) {
						dist[it.getV()] = dist[node]+it.getWeight();
					}
				}
			}
	
		}
		
		for(int i=0;i<n;i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.print("INF");
			else
				System.out.print(dist[i] + " ");
		}
	}
	
	public void topoSort_forShortestpath(int v,List<List<Pair>> adj,boolean[] visited,Stack<Integer> stack) {
		
		visited[v]=true;
		
		for(Pair it : adj.get(v)) {
			if(!visited[it.getV()])
				topoSort_forShortestpath(it.getV(),adj,visited,stack);
		}
		
		stack.push(v);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 6;
		List<List<Pair>> adj = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			adj.add(new ArrayList<>());
		}
		
		adj.get(0).add(new Pair(1,2));
		adj.get(0).add(new Pair(4,1));
		adj.get(1).add(new Pair(2,3));
		adj.get(2).add(new Pair(3,6));
		adj.get(4).add(new Pair(2,2));
		adj.get(4).add(new Pair(5,4));
		adj.get(5).add(new Pair(3,1));
		
		Graph_EdgeWeights g = new Graph_EdgeWeights();
		
		// Shortest Path in Directed Acyclic Graph (DAG)
		g.shortestPath_DAG_BFS(0, adj, n);
	}

}
