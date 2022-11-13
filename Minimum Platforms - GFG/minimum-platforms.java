//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            
            int arr[] = new int[n];
            int dep[] = new int[n];
            
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
              arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                dep[i] = Integer.parseInt(str[i]);
                
            System.out.println(new Solution().findPlatform(arr, dep, n));
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        
        Arrays.sort(arr);
        Arrays.sort(dep);

        int []temp = new int[n];
        temp[0] = dep[0];
        int k = 1;
        int platform = 1;
        int max = dep[0];

        for(int i=1;i<n;++i){
            if(arr[i]>=max){
                max = dep[i];
                for(int z=0;z<k;++z){
                    if(temp[z]<max){
                        temp[z] = max;
                        break;
                    }
                }
            }else{
                boolean flag = true;
                for(int j=0;j<k;++j){
                    if(temp[j]<arr[i]){
                        temp[j] = dep[i];
                        max = dep[i];
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    temp[k++] = dep[i];
                    platform++;
                    max = dep[i];
                }
            }
        }
        return platform;
    }
    
}

