package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {

	private int V; //No. of Vertices
	private LinkedList<Integer> adj[]; //Adjacency Lists
	
	//Constructor
	BFSGraph(int v){
		V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) {
			adj[i]=new LinkedList();
		}
	}
	//Function to add edge in the graph
		public  void addEdge(int v,int w) {
			adj[v].add(w);
		}
		
	//Prints bfs traversal from a given source s
		public void BFS(int s) {
			boolean[] visited = new boolean[V];
			
			//create a queue for bfs
			LinkedList<Integer> queue = new LinkedList<Integer>();
			
			//mark the current node as visited and enqueue it
			visited[s]=true;
			queue.add(s);
			
			while(queue.size()!=0) {
				s=queue.poll();
				System.out.print(s+" ");
				
				//Get all adjacent vertices of dequeued vertex s,if the adjacent has not been visited,then mark it visited and enqueue it
				Iterator<Integer> i = adj[s].listIterator();
				while(i.hasNext()) {
					int n = i.next();
					if(!visited[n]) {
						visited[n]=true;
						queue.add(n);
					}
				}
			}
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         BFSGraph g = new BFSGraph(4);
         
         g.addEdge(0,1);
         g.addEdge(0,2);
         g.addEdge(1,2);
         g.addEdge(2,0);
         g.addEdge(2,3);
         g.addEdge(3,3);
         
         System.out.println("Following is the bfs traversal starting from vertex 2");
         g.BFS(2);
	}

}
