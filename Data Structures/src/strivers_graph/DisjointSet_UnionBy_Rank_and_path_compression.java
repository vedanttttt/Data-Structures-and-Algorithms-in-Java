package strivers_graph;

public class DisjointSet_UnionBy_Rank_and_path_compression {

	int V;
	int parent[];
	int rank[];
	
	public DisjointSet_UnionBy_Rank_and_path_compression(int n) {
		V=n;
		parent = new int[10000];
		rank = new int[10000];
	}
	
	public void makeSet() {
		for(int i=1;i<=V;i++) {
			parent[i] = i;
		}
	}
	
	public int findParent(int node) {
		if(node==parent[node])
			return node;
		
		return parent[node] = findParent(parent[node]);   // it will compress paths also
	}
	
	void union(int u,int v) {
		u = findParent(u);
		v = findParent(v);
		
		if(rank[u]<rank[v])
			parent[u]=v;
		else if(rank[v]<rank[u])
			parent[v]=u;
		else {
			parent[v]=u;
			rank[u]++;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		DisjointSet_UnionBy_Rank_and_path_compression obj = new DisjointSet_UnionBy_Rank_and_path_compression(n);
		obj.makeSet();
		while(n-->1) {   
			obj.union(n,n-1);
		}
		
		//Check if 2 and 3 belong to same or different parent
		if(obj.findParent(2) != obj.findParent(3))
			System.out.println("Different Parents");
		else
			System.out.println("Same Parent");
	}

}
