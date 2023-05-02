//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m=sc.nextInt();
            int[][] edge = new int[m][2];
            for(int i=0;i<m;i++){
                edge[i][0]=sc.nextInt();
                edge[i][1]=sc.nextInt();
            }
            int src=sc.nextInt();
            Solution obj = new Solution();
            int res[] = obj.shortestPath(edge,n,m,src);
            for(int i=0;i<n;i++){
                System.out.print(res[i]+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int[] shortestPath(int[][] edges,int n,int m ,int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;++i){
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i=0;i<m;++i){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        boolean []isVisited = new boolean[n];
        isVisited[src] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        int []dist = new int[n];
        Arrays.fill(dist,1000000);
        dist[src] = 0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            
            for(Integer nodes : adj.get(node)){
              if(!isVisited[nodes]){
                  isVisited[nodes] = true;
              if(dist[node]+1<dist[nodes]){
                 dist[nodes] = dist[node]+1;
                  q.add(nodes);
            }
              }
          }
        }
        
        for(int i=0;i<dist.length;++i){
            if(dist[i]==1000000){
                dist[i] = -1;
            }
        }
        
       
        
        return dist;
    }
}