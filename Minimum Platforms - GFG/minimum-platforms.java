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
        int [][]ans = new int[n][n];
        
        Arrays.sort(arr);
        Arrays.sort(dep);

        for(int i=0;i<n;++i){
            ans[i][0] = arr[i];
            ans[i][1] = dep[i];
        }

        int []temp = new int[n];
        temp[0] = ans[0][1];
        int k = 1;
        int platform = 1;
        int max = ans[0][1];

        for(int i=1;i<n;++i){
            if(ans[i][0]>=max){
                max = ans[i][1];
                for(int z=0;z<k;++z){
                    if(temp[z]<max){
                        temp[z] = max;
                        break;
                    }
                }
            }else{
                boolean flag = true;
                for(int j=0;j<k;++j){
                    if(temp[j]<ans[i][0]){
                        temp[j] = ans[i][1];
                        max = ans[i][1];
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    temp[k++] = ans[i][1];
                    platform++;
                    max = ans[i][1];
                }
            }
        }
        return platform;
    }
    
}

