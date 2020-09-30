package graphs;
import java.util.*;

public class TravellingSalesman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int graph[][] = { { 0, 10, 15, 20 }, 
                { 10, 0, 35, 25 }, 
                { 15, 35, 0, 30 }, 
                { 20, 25, 30, 0 } };
		int s=0;
		System.out.println(travellingsalesman(graph,s));
	}
	
	public static int travellingsalesman(int[][] graph,int s) {
		int V = graph.length;
		List<Integer> vertex = new ArrayList<>();
		
		//store all the vertex apart from source vertex
		for(int i=0;i<V;i++) {
			if(i!=s)
				vertex.add(i);
		}
		
		int minPath = Integer.MAX_VALUE;
		
	}

}
