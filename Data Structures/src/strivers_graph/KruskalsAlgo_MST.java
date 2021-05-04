package strivers_graph;

import java.util.*; 

class Node 
{
	private int u;
    private int v;
    private int weight;
    
    Node(int _u, int _v, int _w) { u = _u; v = _v; weight = _w; }
    
    Node() {}
    
    int getV() { return v; }
    int getU() { return u; }
    int getWeight() { return weight; }

}

class SortComparator implements Comparator<Node> {
	@Override
    public int compare(Node node1, Node node2) 
    { 
        if (node1.getWeight() < node2.getWeight()) 
            return -1; 
        if (node1.getWeight() > node2.getWeight()) 
            return 1; 
        return 0; 
   } 
} 

public class KruskalsAlgo_MST {
	
	public static int findParent(int u,int[] parent) {
		if(u == parent[u])
			return u;
		
		return parent[u] = findParent(parent[u],parent);
	}
	
	public void KruskalAlgo(List<Node> adj,int n) {
		Collections.sort(adj, new SortComparator());
		
		int[] parent = new int[n];
		int[] rank = new int[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
        List<Node> adj = new ArrayList<Node>();
		
			
		adj.add(new Node(0, 1, 2));
		adj.add(new Node(0, 3, 6));
		adj.add(new Node(1, 3, 8));
		adj.add(new Node(1, 2, 3));
		adj.add(new Node(1, 4, 5));
		adj.add(new Node(2, 4, 7));

	
		KruskalsAlgo_MST obj = new KruskalsAlgo_MST(); 
		obj.KruskalAlgo(adj, n);
	}

}
