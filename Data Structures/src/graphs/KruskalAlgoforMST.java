package graphs;
import java.util.*;

class Edge{
	int u;
	int v;
	int weight;
	
	public Edge(int u,int v,int w) {
		this.u=u;
		this.v=v;
		this.weight=w;
	}
	
	int getU() {
		return u;
	}
	int getV() {
		return v;
	}
	int getWeight() {
		return weight;
	}
}

public class KruskalAlgoforMST {
    /**
     * Comparator to sort edges by weight in non decreasing order
     */
    public class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge edge1, Edge edge2) {
            if (edge1.getWeight() <= edge2.getWeight()) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public List<Edge<Integer>> getMST(Graph<Integer> graph) {
        List<Edge<Integer>> allEdges = graph.getAllEdges();
        EdgeComparator edgeComparator = new EdgeComparator();

        //sort all edges in non decreasing order
        Collections.sort(allEdges, edgeComparator);
        DisjointSet disjointSet = new DisjointSet();

        //create as many disjoint sets as the total vertices
        for (Vertex<Integer> vertex : graph.getAllVertex()) {
            disjointSet.makeSet(vertex.getId());
        }

        List<Edge<Integer>> resultEdge = new ArrayList<Edge<Integer>>();

        for (Edge<Integer> edge : allEdges) {
            //get the sets of two vertices of the edge
            long root1 = disjointSet.findSet(edge.getVertex1().getId());
            long root2 = disjointSet.findSet(edge.getVertex2().getId());

            //check if the vertices are in same set or different set
            //if verties are in same set then ignore the edge
            if (root1 == root2) {
                continue;
            } else {
                //if vertices are in different set then add the edge to result and union these two sets into one
                resultEdge.add(edge);
                disjointSet.union(edge.getVertex1().getId(), edge.getVertex2().getId());
            }

        }
        return resultEdge;
    }

    public static void main(String args[]) {
        Graph<Integer> graph = new Graph<Integer>(false);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 5, 1);
        graph.addEdge(2, 6, 3);
        graph.addEdge(2, 4, 2);
        graph.addEdge(6, 5, 2);
        graph.addEdge(6, 4, 3);
        graph.addEdge(4, 7, 2);
        graph.addEdge(3, 4, 5);
        graph.addEdge(3, 7, 8);
 KruskalAlgoforMSTskalMST mstKruskalAlgoforMSTskalMST();
        List<Edge<Integer>> result = mst.getMST(graph);
        for (Edge<Integer> edge : result) {
            System.out.println(edge.getVertex1() + " " + edge.getVertex2());
        }
    }
}