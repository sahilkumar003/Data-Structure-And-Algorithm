//{ Driver Code Starts
//Initial Template for JAVA

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            
            int[] cost = new int[N];
            
            for(int i=0 ; i<N ; i++)
                cost[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.minCostClimbingStairs(cost,N));
        }
    }
}
// } Driver Code Ends


//Back-end complete function Template for Java

class Solution {
    private static int minCost(int currStair, int[]cost, Map<Integer,Integer> cache){
        if(currStair == cost.length){
            return 0;
        }
        
        if(currStair > cost.length){
            return 100000;
        }
        
        int currKey = currStair;
        
        if(cache.containsKey(currKey)){
            return cache.get(currKey);
        }
        
        int oneStep = cost[currStair] + minCost(currStair+1, cost, cache);
        int twoStep = cost[currStair] + minCost(currStair+2, cost, cache);
        
        cache.put(currKey,Math.min(oneStep,twoStep));
        
        return cache.get(currKey);
    }
    
    static int minCostClimbingStairs(int[] cost , int n) {
        Map<Integer,Integer> cache = new HashMap<>();
        return Math.min(minCost(0,cost,cache),cache.get(1));
    }
};