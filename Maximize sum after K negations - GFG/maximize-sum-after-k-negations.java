//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            StringTokenizer stt = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(stt.nextToken());
            int k = Integer.parseInt(stt.nextToken());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maximizeSum(a, n, k));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {

    public static long maximizeSum(long arr[], int n, int k)
    {
        Arrays.sort(arr);
        long sum = 0;
        long maxOfNegative = Integer.MAX_VALUE;
        long minOfPositive = Integer.MAX_VALUE;
        boolean flag = false;
        
        for(int i=0;i<n;++i){
            if(arr[i]<0 && k>0){
                flag = true;
                arr[i] = Math.abs(arr[i]);
                maxOfNegative = Math.min(maxOfNegative,arr[i]);
                k--;
            }else{
                minOfPositive = Math.min(minOfPositive,arr[i]);
            }
            
            sum += arr[i];
        }
        
        if(k%2!=0){
            if(flag){
                long x = Math.min(maxOfNegative,minOfPositive);
                return sum-(2*x);
            }else{
                return sum - (2*minOfPositive);
            }
        }
        
        return sum;
         
    }
}