package graphs;
import java.util.*;


class Grap{
	List<List<Edge>> adj;
	boolean[] visited;
	int nodes;
	
	Grap(int nodes){
		this.nodes=nodes;
		adj=new ArrayList<>();
		visited=new boolean[nodes];
		
		for(int i=0;i<nodes;i++) {
			adj.add(new ArrayList<>());
		}
	}
	
	public void addEdge(int source,int target,int distance) {
		adj.get(source).add(new Edge(target,distance));
		adj.get(target).add(new Edge(source,distance));
	}
	
	public int minimumCost(int source) {
		
		PriorityQueue<Edge> minHeap = new PriorityQueue<>((n1,n2) -> n1.distanceFromNode - n2.distanceFromNode);
		
		visited[source]=true;
		List<Edge> childOfSource = adj.get(source);
		
		for(Edge edge:childOfSource) {
			minHeap.add(edge);
		}
		
		int minCost=0;
		while(!minHeap.isEmpty()) {
			
			Edge minValueEdge = minHeap.poll();
			
			if(visited[minValueEdge.targetNode])
				continue;
			
			visited[minValueEdge.targetNode]=true;
			
			minCost = minCost + minValueEdge.distanceFromNode;
			
			List<Edge> childList = adj.get(minValueEdge.targetNode);
			for(Edge edge:childList) {
				if(!visited[edge.targetNode])
					minHeap.add(edge);
			}
		}
		return minCost;
	}
	
	public int mst() {
		int minCost=0;
		
		for(int i=0;i<nodes;i++) {
			if(!visited[i])
				minCost = minCost + minimumCost(i);
		}
		return minCost;
	}
	
}

public class PrimsAlgoMSTWeightedGraph {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodes=5;
		Grap a = new Grap(5);
		
		a.addEdge(0,1,6);
		a.addEdge(0,3,4);
		a.addEdge(1,3,7);
		a.addEdge(1,4,7);
		a.addEdge(1,2,10);
		a.addEdge(2,3,8);
		a.addEdge(2,4,5);
		a.addEdge(3,4,12);
		
		System.out.println(a.minimumCost(0));
	}

}
