package graphs;
import java.util.*;

class Edge{
	int targetNode;
	int distanceFromNode;
	
	Edge(int targetNode,int distanceFromNode){
		this.targetNode=targetNode;
		this.distanceFromNode=distanceFromNode;
	}
}

class Gr{
	List<List<Edge>> adj;
	boolean[] visited;
	int[] distance;
	
	Gr(int nodes){
		adj=new ArrayList<>();
		visited=new boolean[nodes];
		distance =new int[nodes];
		
		for(int i=0;i<nodes;i++) {
			adj.add(new ArrayList<>());
			distance[i]=Integer.MAX_VALUE;
		}
	}
	
	public void addEdge(int sourceNode,int targetNode,int distance) {
		adj.get(sourceNode).add(new Edge(targetNode,distance));
		adj.get(targetNode).add(new Edge(sourceNode,distance));  //for directed graph ,add only one edge
	}
	
	public int minDistance(int source,int destination) {
		if(source==destination)
			return 0;
		
		PriorityQueue<Edge> minHeap = new PriorityQueue<>((e1,e2) -> e1.distanceFromNode - e2.distanceFromNode);
		
		distance[source]=0;
		minHeap.add(new Edge(0,0));
		
		while(!minHeap.isEmpty()) {
			int v=minHeap.poll().targetNode;
			if(visited[v])  //maybe bcoz one node with two distances are stored in queue 
				continue;
			
			visited[v]=true;
			
			List<Edge> childList = adj.get(v);
			
			for(Edge child:childList) {
				int dist = child.distanceFromNode;
				int childNode = child.targetNode;
				
				if(!visited[childNode] && (distance[v]+dist <distance[childNode])) {
					distance[childNode]=distance[v]+dist;
					child.distanceFromNode=distance[v]+dist;
					minHeap.add(child);
				}
			}
		}
		return distance[destination];
	}
}

public class DijkstraMinDistWeighted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodes=5;
		
		Gr a = new Gr(nodes);
		
		a.addEdge(0,1,1);
		a.addEdge(0,2,7);
		a.addEdge(1,2,5);
		a.addEdge(1,4,4);
		a.addEdge(4,3,2);
		a.addEdge(2,3,6);
		
		System.out.println(a.minDistance(0,3));
	}

}
