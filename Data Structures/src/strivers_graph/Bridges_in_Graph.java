package strivers_graph;
import java.util.*;
public class Bridges_in_Graph {
	
	public void printBridges(List<List<Integer>> adj,int n) {
		int vis[] = new int[n];
		int tin[] = new int[n];
		int low[] = new int[n];
		
		int timer=0;
		for(int i=0;i<n;i++) {
			if(vis[i]==0)
				dfs(i,-1,vis,tin,low,adj,timer);
		}
	}
	
	public void dfs(int node,int parent,int[] vis,int[] tin,int[] low,List<List<Integer>> adj,int timer) {
		vis[node]=1;
		tin[node] = low[node] = timer++;
		
		for(int it : adj.get(node)) {
			if(it == parent)
				continue;
			
			if(vis[it]==0) {
				dfs(it,node,vis,tin,low,adj,timer);
				low[node] = Math.min(low[node],low[it]);
				
				if(low[it] > tin[node]) {     //adjacent node can be reached before that node , ie. this edge will not be bridge as their might be some other edge, and even if we remove this edge , graph will not broke down 
					System.out.println(it + " " + node);
				}
			}
			else {
				low[node] = Math.min(low[node],tin[it]);
			}
		}
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
			
		Bridges_in_Graph obj = new Bridges_in_Graph(); 
		obj.printBridges(adj, n); 
	}

}
