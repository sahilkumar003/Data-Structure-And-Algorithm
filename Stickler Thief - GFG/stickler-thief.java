//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends


class Solution
{
     private int maxCost(int currHouse, int []arr, Map<Integer,Integer> cache){
        if(currHouse>=arr.length){
            return 0;
        }
        
        int currKey = currHouse;
        
        if(cache.containsKey(currKey)){
            return cache.get(currKey);
        }
        
        int rob = arr[currHouse] + maxCost(currHouse+2,arr,cache);
        int notRob = maxCost(currHouse+1,arr,cache);
        
        cache.put(currKey,Math.max(rob,notRob));
        
        return cache.get(currKey);
    }
    
    public int FindMaxSum(int arr[], int n)
    {
        return maxCost(0,arr,new HashMap<Integer,Integer>());
    }
}