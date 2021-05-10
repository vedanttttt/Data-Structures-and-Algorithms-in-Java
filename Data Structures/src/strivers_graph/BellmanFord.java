package strivers_graph;
import java.util.*;

// to implement it , comment dijkstra and kruskal
class Node{
	private int u;
	private int v;
	private int weight;
	
	public Node(int u,int v,int weight) {
		this.u=u;
		this.v=v;
		this.weight=weight;
	}
	
	int getU() {
		return u;
	}
	int getV() {
		return v;
	}
	int getW() {
		return weight;
	}
}

public class BellmanFord {
	
	public void bellmanford(List<Node> adj,int n,int src) {
		int[] dist = new int[n];
		Arrays.fill(dist,1000000);
		dist[src]=0;
		
		for(int i=1;i<n-1;i++) {
			for(Node e : adj) {
				if(dist[e.getU()] + e.getW() < dist[e.getV()]) {
					dist[e.getV()] = dist[e.getU()] + e.getW();
				}
			}
		}
		
		int fl=0;
		for(Node e : adj) {
			if(dist[e.getU()] + e.getW() < dist[e.getV()]) {
				fl=1;
				System.out.println("Negative cycle");
				break;
			}
		}
		
		if(fl==0) {
			for(int i=0;i<n;i++) {
				System.out.println(i + " "  + dist[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		List<Node> adj = new ArrayList<>();
		
		adj.add(new Node(3,2,6));
		adj.add(new Node(5, 3, 1));
		adj.add(new Node(0, 1, 5));
		adj.add(new Node(1, 5, -3));
		adj.add(new Node(1, 2, -2));
		adj.add(new Node(3, 4, -2));
		adj.add(new Node(2, 4, 3));
		
		BellmanFord obj = new BellmanFord();
		obj.bellmanford(adj,n,0);
	}

}
