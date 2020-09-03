package graphs;

import java.util.*;
public class ArrayListRepresentation {

	//Utility function to add an edge in undirected graph
	public static void addEdge(ArrayList<ArrayList<Integer>> adj,int u,int v) {
		adj.get(u).add(v);
		adj.get(v).add(u);
	}
	
	//Utility function to print adjacency list representation of graph
	public static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for(int i=0;i<adj.size();i++) {
			System.out.println("Adjacency list of vertex "+i);
			System.out.print("head");
			for(int j=0;j<adj.get(i).size();j++) {
				System.out.print(" -> "+adj.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Creating a graph with 5 vertices.
		int V=5;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>(V);
		
		for(int i=0;i<V;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		//Adding edges one by one
		addEdge(adj,0,1);
		addEdge(adj,0,4);
		addEdge(adj,1,2);
		addEdge(adj,1,4);
		addEdge(adj,1,3);
		addEdge(adj,2,3);
		addEdge(adj,3,4);
		
		printGraph(adj);
	}

}
