package graphs;
import java.util.*;

class DirectedGraph{
	List<List<Integer>> adj;
	boolean[] visited;
	int V;
	
	DirectedGraph(int v) {
		adj = new ArrayList<>();
		V=v;
		visited=new boolean[v];
		for(int i=0;i<v;i++) {
			adj.add(i, new ArrayList<Integer>());
		}
	}
	
	public void addEdge(int u,int v) {
		adj.get(u).add(v);
	}
	
	public boolean isStronglyConnected() {
		for(int i=0;i<V;i++) {
			dfs(i);
			
			for(int j=0;j<V;j++) {
				if(!visited[j])
					return false;
			}
			Arrays.fill(visited, false);
		}
		return true;
	}
	
	public void dfs(int v) {
		Stack<Integer> stack = new Stack<>();
		visited[v]=true;
		stack.push(v);
		
		while(!stack.isEmpty()) {
			int s = stack.pop();
			
			Iterator<Integer> it = adj.get(s).iterator();
			while(it.hasNext()) {
				Integer i = it.next();
				if(!visited[i]) {
					visited[i]=true;
					stack.push(i);
				}
			}
		}
	}
}

public class StronglyConnectedDirectedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodes=4;
		DirectedGraph g = new DirectedGraph(nodes);
		
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(0,3);
		g.addEdge(3,2);
		
		System.out.println(g.isStronglyConnected());
	}

}
