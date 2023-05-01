//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
	public static void main(String args[]) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
		while(t>0)
		{
		    int N = sc.nextInt();
		    int P = sc.nextInt();
		    int prerequisites[][] = new int[P][2];
		    for(int i=0;i<P;i++)
		    {
		        for(int j=0;j<2;j++)
		        {
		            prerequisites[i][j] = sc.nextInt();
		        }
		    }
			Solution ob = new Solution();
			if(ob.isPossible(N,prerequisites))
			{
			    System.out.println("Yes");
			}
			else{
			    System.out.println("No");
			}
			t--;
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public boolean isPossible(int n, int[][] prerequisites)
    {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;++i){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;++i){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int []inDegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;++i){
            for(Integer nodes : adj.get(i)){
                inDegree[nodes]++;
            }
        }
        
        for(int i=0;i<n;++i){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int []topo = new int[n];
        int i = 0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            
            for(Integer nodes : adj.get(node)){
                inDegree[nodes]--;
                if(inDegree[nodes]==0){
                    q.add(nodes);
                }
            }
            
        }
        
        return i==n;
    }
    
}