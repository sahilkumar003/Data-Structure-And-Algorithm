//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            int V = sc.nextInt();
            int E = sc.nextInt();
            for (int i = 0; i < V; i++)
                list.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                list.get(u).add(v);
            }
            if (new Solution().isCyclic(V, list) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


/*Complete the function below*/

class Solution {
    public boolean dfs(int curr, ArrayList<ArrayList<Integer>> adj, boolean[]isVisited, boolean[]isPath){
        isVisited[curr] = true;
        isPath[curr] = true;
        
        for(Integer nodes : adj.get(curr)){
            if(!isVisited[nodes]){
                if(dfs(nodes,adj,isVisited,isPath)) return true;
            }else if(isPath[nodes]){
                return true;
            }
        }
        
        isPath[curr] = false;
        return false;
    } 
     
    
    public boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean []isVisited = new boolean[v];
        boolean []isPath = new boolean[v];
        
        for(int i=0;i<v;++i){
            if(!isVisited[i]){
                if(dfs(i,adj,isVisited,isPath)){
                    return true;
                }
            }
        }
        
        return false;
    }
}