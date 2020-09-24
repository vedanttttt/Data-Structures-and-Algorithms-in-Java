package graphs;

public class noOfIslands {

	int ROW = 5;
	int COL = 5;
	
	public int countIslands(int mat[][]) {
		boolean visited[][] = new boolean[ROW][COL];
		
		int count=0;
		
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				if(mat[i][j]==1 && !visited[i][j]) {
					dfs(mat,i,j,visited);
					count++;
				}
			}
		}
		return count;
	}
	
	private void dfs(int mat[][],int x,int y,boolean[][] visited) {
		visited[x][y]=true;
		
		if(isSafe(mat,x-1,y-1,visited))
			dfs(mat,x-1,y-1,visited);
		
		if(isSafe(mat,x-1,y,visited))
			dfs(mat,x-1,y,visited);
		
		if(isSafe(mat,x-1,y+1,visited))
			dfs(mat,x-1,y+1,visited);
		
		if(isSafe(mat,x,y+1,visited))
			dfs(mat,x,y+1,visited);
		
		if(isSafe(mat,x+1,y+1,visited))
			dfs(mat,x+1,y+1,visited);
		
		if(isSafe(mat,x+1,y,visited))
			dfs(mat,x+1,y,visited);
		
		if(isSafe(mat,x-1,y+1,visited))
			dfs(mat,x-1,y+1,visited);
		
		if(isSafe(mat,x,y-1,visited))
			dfs(mat,x,y-1,visited);
		
	}
	
	private boolean isSafe(int mat[][],int x,int y,boolean[][] visited) {
		return x>=0 && x<ROW && y>=0 && y<COL && mat[x][y]==1 && !visited[x][y];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		noOfIslands a = new noOfIslands();
		
		int[][] mat = {
				{0,1,0,0,1},
				{1,1,0,0,0},
				{1,0,0,1,1},
				{0,0,0,0,0},
				{1,0,0,0,1}
		};
		
		System.out.println(a.countIslands(mat));
	}

}
