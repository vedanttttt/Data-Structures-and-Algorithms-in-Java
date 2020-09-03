package graphs;

import java.util.Stack;

class Vertex{
	public char label;
	public boolean wasVisited;
	
	public Vertex(char lab) {
		label=lab;
		wasVisited=false;
	}
}

class Graph{
	private final int MAX_VERTS =20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Stack<Integer> s;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts=0;//It will track how many vertices we have added into graph
		s = new Stack<Integer>();
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start,int end) {
		adjMat[start][end]=1;
		adjMat[end][start]=1;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label+" ");
	}
	
	public int getAdjUnvisitedVertex(int v) {
		for(int j=0;j<nVerts;j++) {
			if(adjMat[v][j] == 1 && vertexList[j].wasVisited==false) {
				return j;
			}
		}
		return -1;
	}
	
	public void dfs() {
		vertexList[0].wasVisited=true;
		displayVertex(0);
		s.push(0);
		
		while(!s.isEmpty()) {
			int v = getAdjUnvisitedVertex(s.peek());
		   
			if(v==-1) {
				s.pop();
			}
			else {
				vertexList[v].wasVisited=true;
				displayVertex(v);
				s.push(v);
			}
		}
	}
}


public class DFSApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		theGraph.addVertex('F');
		
		theGraph.addEdge(0,1);
		theGraph.addEdge(1,2);
		theGraph.addEdge(0,3);
		theGraph.addEdge(3,4);
		theGraph.addEdge(4,5);
		theGraph.addEdge(1,3);
		
		System.out.println("Visits: ");
		theGraph.dfs();
		System.out.println();
	}

}
/* package codechef; // don't place package name! */
/*
import java.util.*;
import java.lang.*;
import java.io.*;
*/
/* Name of the class has to be "Main" only if the class is public. */
/*
 class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		
    	Scanner sc = new Scanner(System.in);
		if(sc.hasNextInt()){
		    int k = sc.nextInt();
		    int[] ar = new int[k];
		   //while(sc.hasNextInt()){
		   for(int i=0;i<k;i++){
		        int l = sc.nextInt();
		        int[] ar1 = new int[l];
		        int[] ar2 = new int[l];
		        for(int i1=0;i1<l;i1++){
		            ar1[i1]=sc.nextInt();
		        }
		        for(int i1=0;i1<l;i1++){
		            ar2[i1]=sc.nextInt();
		        }
		        sc.nextLine();
		        int i1=0,sum1=0,sum2=0,dist=0;
		        while(i1!=l){
		            sum1=sum1+ar1[i1];
		            sum2 = sum2+ar2[i1];
		            if(sum1==sum2 && ar1[i1]==ar2[i1]) {
		             dist +=ar1[i1];
		            }
		             i1++;
		        }
		        
		        ar[i]=dist;
		    }
		    for(int d: ar)
		    System.out.println(d);
		}
	}
}
 
 
 // int ar[] = new int[k];
//  for(int i=0;i<k;i++){
 // while(k>0){
 
 
 
 //continue;
//   ar[i]=dist;

// for(int d: ar)
//  System.out.println(d);
*/




