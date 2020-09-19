package graphs;
import java.util.*;

class GGraph{
	List<List<Integer>> graph;
	Map<Integer,Integer> incomingDegree;
	int visitedNodes;
	int nodes;
	Queue<Integer> sourceQueue;
	
	GGraph(int nodes){
		graph = new ArrayList<>();
		incomingDegree = new HashMap<>();
		sourceQueue = new LinkedList<>();
		this.nodes=nodes;
		visitedNodes=0;
		
		for(int i=0;i<nodes;i++) {
			graph.add(i, new ArrayList<>());
			incomingDegree.put(i,0);
		}
	}
	
	public void addEdge(int a,int b) {
		graph.get(a).add(b);
		incomingDegree.put(b,incomingDegree.get(b)+1);
	}
	
	public boolean checkCycle() {
		
		for(Map.Entry<Integer,Integer> entry: incomingDegree.entrySet()) {
			if(entry.getValue()==0) {
				sourceQueue.add(entry.getKey());
			}
		}
		
		while(!sourceQueue.isEmpty()) {
			visitedNodes++;
			int source = sourceQueue.remove();
			
			List<Integer> childrenList = graph.get(source);
			for(Integer child : childrenList) {
				incomingDegree.put(child,incomingDegree.get(child)-1);
				
				if(incomingDegree.get(child)==0)
					sourceQueue.add(child);
			}
		}
		return visitedNodes!=nodes;
	}
}

public class CycleDirectedUsingBfs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int nodes=4;
		GGraph g = new GGraph(4);
		
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,0);
		g.addEdge(3,0);
		
		System.out.println(g.checkCycle());
	}

}
