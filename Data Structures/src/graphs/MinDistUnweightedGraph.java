package graphs;
import java.util.*;
class G{
	List<List<Integer>> adj;
	boolean[] visited;
	
	G(int v){
		adj=new ArrayList<>();
		visited=new boolean[v];
		
		for(int i=0;i<v;i++) {
			adj.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int u,int v) {
		adj.get(u).add(v);
	}
	
	public int minDistanceSourceDestination(int start,int target) { //startindex and target index
		if(start==target)
			return 0;
		
		Queue<Integer> q = new LinkedList<>();
		int minDistance=0;
		
		q.add(start);
		visited[start]=true;
		
		while(!q.isEmpty()) {
			int size=q.size();
			
			while(size>0) {
				Integer node =q.poll();
				
				List<Integer> childList = adj.get(node);
				
				for(Integer child:childList) {
					if(child==target)
						return ++minDistance;
					if(!visited[child]) {
						q.add(child);
						visited[child]=true;
					}
				}
				size--;
			}
			minDistance++;
		}
		return -1; //means not possible
	}
}

public class MinDistUnweightedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodes=6;
		G a = new G(nodes);
		a.addEdge(0,1);
		a.addEdge(0,3);
		a.addEdge(1,2);
		a.addEdge(3,4);
		a.addEdge(2,4);
		a.addEdge(4,5);
		
		System.out.println(a.minDistanceSourceDestination(0,5));
	}

}
