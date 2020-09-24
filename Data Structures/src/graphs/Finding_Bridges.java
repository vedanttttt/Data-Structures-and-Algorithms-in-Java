package graphs;

import java.util.*;

class Graph1 {

	private int V;
	private List<List<Integer>> adj;
	int time=0;
	
	Graph1(int v){
		V=v;
		adj = new LinkedList<>();
		for(int i=0;i<v;i++) { 
			adj.add(i, new ArrayList<>());
		}
	}
	
	public  void addEdge(int v,int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	public void bridge() {
		boolean[] visited = new boolean[V];
		int[] disc = new int[V];
		int[] low = new int[V];
		int[] parent = new int[V];
		
		Arrays.fill(parent,-1);
		
		for(int i=0;i<V;i++) {
			if(!visited[i])
				bridgeUtil(i,visited,disc,low,parent);
		}
	}
	
	public void bridgeUtil(int u,boolean[] visited,int[] disc,int[] low,int[] parent) {
		
		visited[u]=true;
		
		disc[u] = low[u] = ++time;
		
		List<Integer> l = adj.get(u);
		for(int v:l) {
			if(!visited[v]) {
				parent[v]=u;
				bridgeUtil(v,visited,disc,low,parent);
				
				low[u]= Math.min(low[u],low[v]);
				
				if(low[v]>disc[u])
					System.out.println(u+" "+v);
			}
			else if(v != parent[u])
				low[u] = Math.min(low[u],disc[v]);
		}
	}
	
}

public class Finding_Bridges {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph1 g1 = new Graph1(5); 
        g1.addEdge(1, 0); 
        g1.addEdge(0, 2); 
        g1.addEdge(2, 1); 
        g1.addEdge(0, 3); 
        g1.addEdge(3, 4); 
        g1.bridge(); 
        System.out.println(); 
	}

}
