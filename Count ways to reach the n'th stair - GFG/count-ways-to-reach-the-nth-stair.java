//{ Driver Code Starts
import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) {
		
		//taking input using Scanner class
		Scanner sc = new Scanner(System.in);
		
		//taking total testcases
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    //taking count of stairs
		    int m = sc.nextInt();
		    
		    //creating an object of class DynamicProgramming
		    Solution obj = new Solution();
		    
		    //calling method countWays() of class
		    //DynamicProgramming
		    System.out.println(obj.countWays(m));
		    
		}
		
	}
}
// } Driver Code Ends


class Solution
{
    private int totalWays(int currStair, int target, Map<Integer,Integer> memo){
        if(currStair==target){
            return 1;
        }
        if(currStair>target){
            return 0;
        }
        
        int currStairKey = currStair;   //extra local variable for non changing parameter
        
        if(memo.containsKey(currStairKey)){  //if we already calculated then just return result
            return memo.get(currStairKey);
        }
        
        int oneSteps = totalWays(currStair+1,target,memo);
        int twoSteps = totalWays(currStair+2,target,memo);
        
        memo.put(currStairKey,(oneSteps+twoSteps)%(1000000007)); //storing result
        
        return memo.get(currStairKey);
    }
    int countWays(int n)
    {
       return totalWays(0,n,new HashMap<Integer,Integer>());
    }
}

