package strivers_graph;

import java.util.*;

public class Graph {

	private static int V; //No. of Vertices
	private static List<List<Integer>> adj; //Adjacency Lists
	
	//Constructor
	Graph(int v){
		V=v;
		adj = new ArrayList<>();
		for(int i=0;i<v;i++) {
			adj.add(i,new ArrayList<>());
		}
	}
	
	//Function to add edge in the graph
	public  void addEdge(int v,int w) {
		adj.get(v).add(w);
		adj.get(w).add(v);
	}
	
	public int bfs() {
		
		int count=0; //no. of connected components
		boolean[] visited = new boolean[V];
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<V;i++) {
			if(!visited[i]) {
				count++;
				q.add(i);
				visited[i]=true;
				
				while(!q.isEmpty()) {
					int temp = q.poll();
					System.out.print(temp+" ");
					List<Integer> children = adj.get(temp);
					for(int child : children) {
						if(!visited[child]) {
							q.offer(child);
							visited[child]=true;
						}
					}
				}
			}
		}
		System.out.println();
		return count;
	}
	
	public boolean detectcycleBfs() {
		
		Queue<int[]> q = new LinkedList<>();
		boolean[] visited = new boolean[V];
		
		for(int i=1;i<V;i++) {
			if(!visited[i]) {
				visited[i]=true;
				q.add(new int[] {i,-1});
				
				while(!q.isEmpty()) {
					int[] ar = q.poll();
					int temp = ar[0];
					int parent=ar[1];
					
					List<Integer> children = adj.get(temp);
					for(int child : children) {
						if(visited[child] && child!=parent)
							return true;
						if(!visited[child]) {
							visited[child]=true;
							q.add(new int[] {child,temp});
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean detectcycleDFS() {
		
		boolean[] visited = new boolean[V];
		
		for(int i=1;i<V;i++) {
			if(!visited[i]) {
				if(dfs(i,-1,visited))
					return true;
			}
		}
		
		return false;
	}
	
	public boolean dfs(int v,int parent,boolean[] visited) {
		visited[v]=true;
		List<Integer> children = adj.get(v);
		for(int child : children) {
			if(!visited[child]) {
				if(dfs(child,v,visited))
					return true;
			}
			else if(child != parent)
				return true;
		}
		
		return false;
	}
	
	public boolean checkBipartileDFS() {
		int[] color = new int[V];
		Arrays.fill(color, -1);
		
		for(int i=1;i<V;i++) {
			if(color[i]==-1) {
				if(!dfsBipartile(i,color))
					return false;
			}
		}
		
		return true;
	}
	
	public boolean dfsBipartile(int v,int[] color) {
		if(color[v]==-1)
			color[v]=1;
		
		for(int child : adj.get(v)) {
			
			if(color[child]!=-1) {
				if(color[child]==color[v])
					return false;
			}
			else {
				color[child]=1-color[v];
				if(!dfsBipartile(child,color))
					return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Graph g = new Graph(8);
        
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(2,7);
        g.addEdge(7,5);
        //g.addEdge(3,5);
        g.addEdge(4,6);
        
	       // System.out.println("Following is the bfs traversal starting from vertex 1");
	       // System.out.println(g.bfs());
	        
	       //System.out.println(g.detectcycleBfs());
	        
	     // System.out.println(g.detectcycleDFS());
        
       System.out.println(g.checkBipartileDFS());
        
	}

}
