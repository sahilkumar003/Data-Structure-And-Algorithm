//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution{
    
    /*  Function to calculate the longest consecutive ones
    *   N: given input to calculate the longest consecutive ones
    */
    private static String convertIntoBinary(int n){
        String s = "";
        while(n>0){
            int rem = n%2;
            n = n/2;
            s += rem;
        }
        
        return s;
    }
    
    public static int maxConsecutiveOnes(int n) {
        String binary = convertIntoBinary(n);
        
        int max = 0;
        int count = 0;
        for(int i=0;i<binary.length();++i){
            int temp = binary.charAt(i) - '0';
            if(temp==1){
                count += 1;
            }else{
                count = 0;
            }
            max = Math.max(max,count);
        }
        return max;
    }
}



//{ Driver Code Starts.

class Main {
    
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();//testcases
		while(t-->0){
		    int n = sc.nextInt();//input n
		    
		    Solution obj = new Solution();
		    
		    //calling maxConsecutiveOnes() function
		    System.out.println(obj.maxConsecutiveOnes(n));
		}
	}
}



// } Driver Code Ends