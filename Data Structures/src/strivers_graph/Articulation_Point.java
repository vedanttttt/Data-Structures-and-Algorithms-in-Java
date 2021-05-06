package strivers_graph;

import java.util.ArrayList;
import java.util.List;

public class Articulation_Point {
	
	public void printArticulation(List<List<Integer>> adj,int n) {
		boolean[] visited = new boolean[n];
		int[] tin = new int[n];  // time of insertion
		int[] low = new int[n];
		
		int[] isArticulation = new int[n];
		
		int timer=0;
		for(int i=0;i<n;i++) {
			if(!visited[i])
				dfs(i,-1,adj,visited,tin,low,timer,isArticulation);
		}
		
		for(int i=0;i<n;i++) {
			if(isArticulation[i]==1)
				System.out.println(i);
		}
	}
	
	public void dfs(int node,int parent,List<List<Integer>> adj,boolean[] visited,int[] tin,int[] low,int timer,int[] isArticulation) {
		visited[node]=true;
		tin[node] = low[node] = timer++;
		int child=0;
		
		for(int it : adj.get(node)) {
			if(it == parent)
				continue;
			
			if(!visited[it]) {
				dfs(it,node,adj,visited,tin,low,timer,isArticulation);
				low[node] = Math.min(low[node],low[it]);
				
				if(low[it]>tin[node] && parent != -1) {
					isArticulation[node]=1;
				}
				child++;
			}
			else {
				low[node] = Math.min(low[node],tin[it]);  // if node is visited , its time of insertion will definitely be smaller than low of node
			}
		}
		
		if(parent == -1 && child>1) 
			isArticulation[node]=1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 5;
        List<List<Integer> > adj = new ArrayList<>();
		
		for (int i = 0; i < n; i++) 
			adj.add(new ArrayList<Integer>());
			
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(2);
		adj.get(2).add(1);

		adj.get(1).add(3);
		adj.get(3).add(1);

		adj.get(3).add(4);
		adj.get(4).add(3);
			
		Articulation_Point obj = new Articulation_Point(); 
		obj.printArticulation(adj, n); 
	}

}
