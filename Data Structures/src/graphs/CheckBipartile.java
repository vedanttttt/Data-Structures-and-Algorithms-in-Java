package graphs;
import java.util.*;
class BG{
	int V;
	List<List<Integer>> adj;
	
	public BG(int nodes) {
		this.V=nodes;
		adj = new ArrayList<>();
		
		for(int i=0;i<V;i++)
			adj.add(i, new ArrayList<>());
	}
	
	public void addEdge(int a,int b) {
		adj.get(a).add(b);
		adj.get(b).add(a);
	}

	public boolean whetherGraphIsBipartileUtil(int[] color,int s) {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<>();
		color[s]=1;
		q.add(s);
		
		while(!q.isEmpty()) {
			int v = q.poll();
			List<Integer> l = adj.get(v);
			
			for(int e:l) {
				if(e==v) //incase vertex contains self loop 
					return false;
				
				if(e==-1) {
					color[e]=1-color[v];
					q.add(e);
				}
				else if(color[e]==color[v])
					return false;
			}
		}
		return true;
	}
	
	//This function is to handle disconnected graph
	public boolean whetherGraphIsBipartile() {
		int[] color = new int[V];
		Arrays.fill(color, -1);
		
		for(int i=0;i<V;i++) {
			if(color[i]== -1)
				if(whetherGraphIsBipartileUtil(color,i) == false)
					return false;
		}
		return true;
	}
}

public class CheckBipartile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BG g = new BG(7);
		g.addEdge(0,3);
		g.addEdge(0,1);
		g.addEdge(1,4);
		g.addEdge(0,3);
		g.addEdge(4,6);
		g.addEdge(1,5);
		g.addEdge(2,5);
		
		System.out.println(g.whetherGraphIsBipartile());
	}

}
