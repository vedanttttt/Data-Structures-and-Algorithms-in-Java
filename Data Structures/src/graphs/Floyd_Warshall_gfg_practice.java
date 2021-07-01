package graphs;

public class Floyd_Warshall_gfg_practice {

	    public void shortest_distance(int[][] matrix)
	    {
	        // Code here 
	        int n = matrix.length;
	        
	        for(int i=0;i<n;i++){
	            for(int j=0;j<n;j++){
	                if(matrix[i][j]==-1)
	                    matrix[i][j]=1000000000;
	            }
	        }
	        
	        for(int k=0;k<n;k++){
	            
	            for(int i=0;i<n;i++){
	                // if(i==k)
	                //     continue;
	                    
	                for(int j=0;j<n;j++){
	                    // if(j==k)
	                    //     continue;
	                    // if(i==j)
	                    //     continue;
	                    // if(matrix[i][j] == -1)
	                    //     continue;
	                    // if(matrix[i][k]==-1 || matrix[k][j]==-1)
	                    //     continue;
	                        
	                    if(matrix[i][k] + matrix[k][j] < matrix[i][j])
	                        matrix[i][j] = matrix[i][k] + matrix[k][j];
	                }
	            }
	        }
	        
	        // for(int i=0;i<n;i++){
	        //     for(int j=0;j<n;j++){
	        //         System.out.println(matrix[i][j]);
	        //     }
	        // }
	    }
	}
