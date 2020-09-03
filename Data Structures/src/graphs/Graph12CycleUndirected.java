package graphs;
import java.util.*;
class Udg{
	int V;
	boolean[] visited;
	List<List<Integer>> adj;
	
	Udg(int v){
		adj = new ArrayList<>();
		V=v;
		visited=new boolean[v];
		
		for(int i=0;i<v;i++) {
			adj.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int u,int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	public boolean isCycle() {
		for(int i=0;i<V;i++) {
			if(!visited[i]) {   //in case graph is not connected,so in order to traverse all components we are using this for loop and if statement
				if(dfs(i,-1))
					return true;
			}
		}
		return false;
	}
	
	public boolean dfs(int i,int parent) {
		visited[i]=true;
		
		Iterator<Integer> it = adj.get(i).iterator();
		while(it.hasNext()) {
			int n=it.next();
			if(!visited[n])
				dfs(n,i);
			else if(n != parent)
				return true;
		}
		return false;
	}
}

public class Graph12CycleUndirected {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodes=3;
		Udg g = new Udg(nodes);
		
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,0);
		
		System.out.println(g.isCycle());
	}

}
