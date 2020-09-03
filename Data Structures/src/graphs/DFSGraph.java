package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Stack;

public class DFSGraph {

	private int V;
	private LinkedList<Integer> adj[];
	
	DFSGraph(int v){
		V=v;
		adj = new LinkedList[v];
		for(int i=0;i<v;i++) { 
			adj[i]=new LinkedList();
		}
	}
	
	public  void addEdge(int v,int w) {
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public void dfs(int s) {
		boolean[] visited = new boolean[V];
		Stack<Integer> stack = new Stack<>();
		visited[s]=true;
		stack.push(s);
		//System.out.print(s+" ");
		while(stack.size()!=0) {
			s = stack.pop();
			System.out.print(s+" ");
			
			ListIterator<Integer> i = adj[s].listIterator();
			while(i.hasNext()) {
				int n = i.next();
				if(!visited[n]) {
					visited[n]=true;
					stack.push(n);
					//System.out.print(n+" ");
				}
			}
		}
		System.out.println();
	}
	
	//Without using stack
	
	public void DFS(int v) {
		boolean[] visited = new boolean[V];
		DFSUtil(v,visited);
	}
	
	//  MST 
	/*public void DFSUtil(int v,boolean[] visited) {
		visited[v]=true;
		//System.out.print(v+" ");
		
		ListIterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				System.out.print(v+""+n+" ");
				DFSUtil(n,visited);
			}
		}
	}
	*/
	
	  public void DFSUtil(int v,boolean[] visited) {
		visited[v]=true;
		System.out.print(v+" ");
		
		ListIterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n,visited);
			}
		}
	}
	  
	  public boolean isGraphConnected(int v) {
		//  boolean isConnected=false;
		  
		  boolean[] visited=new boolean[V];
		  Stack<Integer> stack = new Stack<>();
		  visited[v]=true;
		  stack.push(v);
		  
		  while(!stack.isEmpty()) {
			  int s=stack.pop();
			  Iterator<Integer> it = adj[s].iterator();
			  while(it.hasNext()) {
				  int i =it.next();
				  if(!visited[i]) {
					  visited[i]=true;
					  stack.push(i);
				  }
			  }
		  }
		  for(int i=0;i<visited.length;i++) {
			  if(visited[i]==false)
				  return false;
		  }
		  return true;
	  }
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DFSGraph a = new DFSGraph(5);
		
		/*g.addEdge(0, 1); 
        g.addEdge(0, 2); 
        g.addEdge(1, 2); 
      //  g.addEdge(2, 0); 
        g.addEdge(2, 3); 
        g.addEdge(3, 3); 
  */
		a.addEdge(0, 1); 
	    a.addEdge(0, 2); 
	    a.addEdge(0, 3); 
	    a.addEdge(0, 4); 
	    a.addEdge(1, 2); 
	    a.addEdge(1, 3); 
	    a.addEdge(1, 4); 
	    a.addEdge(2, 3); 
	    a.addEdge(2, 4); 
	    a.addEdge(3, 4);
        System.out.println("Following is Depth First Traversal "+ 
                           "(starting from vertex 2)"); 
  
        a.dfs(0); //using stack
        
        a.DFS(0); //recursive: without using stack
        System.out.println(a.isGraphConnected(0));
	}

}
