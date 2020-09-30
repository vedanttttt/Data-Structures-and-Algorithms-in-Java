package graphs;
import java.util.*;
class KG{
	int V;
	List<List<Integer>> adj;
	
	KG(int nodes){
		this.V = nodes;
		adj = new ArrayList<>();
		
		for(int i=0;i<V;i++) {
			adj.add(i,new ArrayList<>());
		}
	}
	
	public void addEdge(int a,int b) {
		adj.get(a).add(b);
	}
	
	public void printSCCs() {
		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[V];
		
		for(int i=0;i<V;i++)
			if(!visited[i])
				fillOrder(i,s,visited);
		
		KG g = getTranspose();
		
		Arrays.fill(visited, false);
		
		while(!s.isEmpty()) {
			int v = s.pop();
			if(!visited[v]) {
				g.dfsUtil(v,visited);
				System.out.println();
			}
		}
		
	}
	
	public void fillOrder(int v,Stack<Integer> s,boolean[] visited) {
		visited[v]=true;
		List<Integer> l = adj.get(v);
		for(int e:l) {
			if(!visited[e])
				fillOrder(e,s,visited);
		}
		s.push(v);
	}
	
	public KG getTranspose() {
		KG gr = new KG(V);
		
		for(int v=0;v<V;v++) {
			List<Integer> l = adj.get(v);
			for(int e:l)
				gr.adj.get(e).add(v);
		}
		return gr;
	}
	
	public void dfsUtil(int v,boolean[] visited) {
		visited[v]=true;
		System.out.print(v+" ");
		
		List<Integer> l = adj.get(v);
		for(int e:l) {
			if(!visited[e])
				dfsUtil(e,visited);
		}
	}
}

public class KosarajuStronglyConnectedComponents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KG g = new KG(5); 
        g.addEdge(1, 0); 
        g.addEdge(0, 2); 
        g.addEdge(2, 1); 
        g.addEdge(0, 3); 
        g.addEdge(3, 4); 
  
        System.out.println("Following are strongly connected components "+ 
                           "in given graph "); 
        g.printSCCs();
	}

}
