package disjointSets;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {
    // Write your code here
        int n = gb.size()*2;
        
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];
        
        for(int i=1;i<=n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        
        for(List<Integer> edge : gb){
            int u = edge.get(0);
            int v = edge.get(1);
            
            int p1 = findParent(u,parent);
            int p2 = findParent(v,parent);
            
            if(p1==p2)
                continue;
            
            if(rank[p1]<rank[p2]){
                parent[p1]=p2;
                rank[p2] += rank[p1];
            }
            else{
                parent[p2]=p1;
                rank[p1] += rank[p2];
            }
        }
        
        int max=2,min=n;
        
        for(int i=1;i<=n;i++){
            if (parent[i] != i) continue;
            if (rank[i] == 1) continue;
            min = Math.min(min, rank[i]);
            max = Math.max(max, rank[i]);
        }
        
        //System.out.println(Arrays.toString(rank));
        
        List<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(max);
        
        return res;
    }

    public static int findParent(int node,int[] parent){
        if(node == parent[node])
            return node;
            
        return parent[node]=findParent(parent[node],parent);
    }
}

public class Hackerrank_ques_components_in_graph {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.componentsInGraph(gb);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

