package graphs;
import java.util.*;
	
	class AG{
		int V;
		List<List<Integer>> adj;
		
		public AG(int nodes) {
			this.V=nodes;
			adj = new ArrayList<>();
			
			for(int i=0;i<V;i++) {
				adj.add(i, new ArrayList<>());
			}
		}
		
		public void addEdge(int a,int b) {
			adj.get(a).add(b);
		}
		
		public int findLongestPath(int n) {
			
			int[] dp = new int[n+1];
			boolean[] visited = new boolean[n+1];
			
			for(int i=0;i<n;i++) {
				if(!visited[i])
					dfs(i,dp,visited);
			}
			
			int ans=0;
			for(int i=0;i<=n;i++) {
				ans = Math.max(ans, dp[i]);
			}
			
			System.out.println(Arrays.toString(dp));
			return ans;
		}
		
		public void dfs(int node,int[] dp,boolean[] visited) {
			
			visited[node]=true;
			
			List<Integer> l = adj.get(node);
			for(int e:l) {
				if(!visited[e])
					dfs(e,dp,visited);
				
				dp[node] = Math.max(dp[node], 1 + dp[e]);
			}
		}
	}
	
public class LongestPathInDirectedAcyclicGraph {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5; 
        AG graph = new AG(n); 
        graph.addEdge( 1, 2); 
        graph.addEdge( 1, 3); 
        graph.addEdge( 3, 2); 
        graph.addEdge( 2, 4); 
        graph.addEdge( 3, 4); 
        graph.findLongestPath(n); 
        System.out.println( graph.findLongestPath( n)); 
	}

}
