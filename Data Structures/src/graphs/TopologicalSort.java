package graphs;

import java.util.*;

public class TopologicalSort {

		private int V;
		private ArrayList<ArrayList<Integer>> adj;
		
		TopologicalSort(int v){
			V=v;
			adj = new ArrayList<>(v);
			for(int i=0;i<v;i++) {
				adj.add(new ArrayList<Integer>());
			}
		}
	
	public void addEdge(int u,int v) {
		adj.get(u).add(v);
	}
		
	public void topologicalSortUtil(int v,boolean[] visited,Stack<Integer> stack) {
		
		visited[v]=true;
		Integer i;
		
		Iterator<Integer> it = adj.get(v).iterator();
		while(it.hasNext()) {
			i=it.next();
			if(!visited[i])
				topologicalSortUtil(i,visited,stack);
		}
		
		stack.push(v);
	}
		
	public void topologicalSort() {
		
		Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[V];
		for(int i=0;i<V;i++) {
			visited[i]=false;
		}
		
		for(int i=0;i<V;i++) {
			if(visited[i]==false) {
				topologicalSortUtil(i,visited,stack);
			}
		}
		
		while(!stack.isEmpty())
			System.out.print(stack.pop()+" ");
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSort g = new TopologicalSort(6);
		g.addEdge(5,2);
		g.addEdge(5,0);
		g.addEdge(4,0);
		g.addEdge(4,1);
		g.addEdge(2,3);
		g.addEdge(3,1);
		
		System.out.println("Following is the topological sort of the given graph");
		g.topologicalSort();
	}

}
