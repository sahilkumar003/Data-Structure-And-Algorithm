//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Collections;


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int N = sc.nextInt();
            int[] A = new int[N];
            int[] B = new int[N];
            for (int i = 0; i < N; ++i){
                A[i] = sc.nextInt();
            }
            for (int i = 0; i < N; ++i){
                B[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long ans = ob.findMinSum(A,B,N);
            System.out.println(ans);
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
    long findMinSum(int[] arr1,int[] arr2,int n) { 
       Arrays.sort(arr1);
       Arrays.sort(arr2);
        
        long sum = 0;
        for(int i=0;i<n;++i){
            sum += Math.abs(arr1[n-1-i]-arr2[n-1-i]);
        }
        
        return sum;
    }
}