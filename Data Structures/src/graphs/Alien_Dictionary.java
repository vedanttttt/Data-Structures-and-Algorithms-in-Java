package graphs;
import java.util.*;

 class Gra{
	int V;
	List<List<Integer>> adj;
	boolean[] visited;
	
	Gra(int nodes){
		this.V=nodes;
		adj = new ArrayList<>();
		visited = new boolean[V];
		
		for(int i=0;i<V;i++) {
			adj.add(i, new ArrayList<>());
		}
	}
	
	public void addEdge(int a,int b) {
		adj.get(a).add(b);
	}
	
public String topologicalSort() {
		
	Stack<Integer> s = new Stack<>();
		for(int i=0;i<V;i++) {
			if(!visited[i])
				topologicalUtil(i,s);
		}
		
	String str="";
	while(!s.isEmpty()) {
		str += ((char)(s.pop()+'a') + " ");
	}
	return str;
	}

public void topologicalUtil(int v,Stack<Integer> s) {
	visited[v]=true;
	
	List<Integer> l = adj.get(v);
	for(int c: l) {
		if(!visited[c])
			topologicalUtil(c,s);
	}
	
	if(!adj.get(v).isEmpty())
		s.push(v);
}

public void printGraph() {
	for(int i=0;i<V;i++) {
		System.out.println(adj.get(i));
	}
}
}

public class Alien_Dictionary {

	public static void printOrder(String[] words,int n) {
		Gra g = new Gra(26);
		
		for(int i=0;i<words.length-1;i++) {
			
			String word1 = words[i];
			String word2 = words[i+1];
			
			for(int j=0;j<Math.min(word1.length(),word2.length());j++) {
				if(word1.charAt(j)!=word2.charAt(j)) {
					g.addEdge(word1.charAt(j)-'a',word2.charAt(j)-'a');
					break;
				}
			}
		}
		
		System.out.println(g.topologicalSort());
		//g.printGraph();
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String[] words = {"caa", "aaa", "aab"}; 
		String[] words = {"wrt","wrf","er","ett","rftt"};
        printOrder(words,5);
        
        //ans will be wertf but it will not print f due to some errors
        
	}

}
