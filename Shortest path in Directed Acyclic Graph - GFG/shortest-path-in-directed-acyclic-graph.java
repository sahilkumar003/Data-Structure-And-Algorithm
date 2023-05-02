//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    class Pair{
        int node;
        int weight;
        
        public Pair(int node, int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    
    public void dfs(int curr, boolean []isVisited, Stack<Integer> stack, ArrayList<ArrayList<Pair>> adj){
        isVisited[curr] = true;
        
        for(Pair p : adj.get(curr)){
            if(!isVisited[p.node]){
                dfs(p.node,isVisited,stack,adj);
            }
        }
        
        stack.push(curr);
    }

	public int[] shortestPath(int n,int m, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		
		for(int i=0;i<n;++i){
		    ArrayList<Pair> temp = new ArrayList<>();
		    adj.add(temp);
		}
		
		for(int i=0;i<m;++i){
		    int u = edges[i][0];
		    int v = edges[i][1];
		    int weight = edges[i][2];
		    
		    adj.get(u).add(new Pair(v,weight));
		}
		
		boolean []isVisited = new boolean[n];
		Stack<Integer> stack = new Stack<>();
		
		for(int i=0;i<n;++i){
		    if(!isVisited[i]){
		        dfs(i,isVisited,stack,adj);
		    }
		}
		
		int []dist = new int[n];
		Arrays.fill(dist,10000006);
		
		dist[0] = 0;
		
		while(!stack.isEmpty()){
		    int temp = stack.peek();
		    stack.pop();
		    
		    for(Pair p : adj.get(temp)){
		      int node = p.node;
		      int weight = p.weight;
		      
		      if(dist[temp]+weight < dist[node]){
		          dist[node] = dist[temp]+weight;
		      }
		    }
		}
		
		for(int i=0;i<dist.length;++i){
		    if(dist[i]==10000006){
		        dist[i] = -1;
		    }
		}
		
		return dist;
	}
}