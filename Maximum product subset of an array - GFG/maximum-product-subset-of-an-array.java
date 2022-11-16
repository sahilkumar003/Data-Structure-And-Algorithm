//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.findMaxProduct(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int findMaxProduct(int n, int[] arr) {
        
        if(n == 1){
           return arr[0];
       }

       long product = 1;
       int negative = 0;
       int zero = 0;
       int minNegative = Integer.MIN_VALUE;

       for(int i=0;i<n;++i){
           if(arr[i]!=0){
               product *= arr[i];
               product %= 1000000007;
           }
           if(arr[i]<0){
               negative++;
               minNegative = Math.max(minNegative,arr[i]);
           }
           if(arr[i]==0) {
               zero++;
           }
       }

       if(((negative==1) && (zero>0) && (negative+zero)==n) || (zero == n)){
           return 0;
       }

       if(negative%2!=0){
           return (int)(product/minNegative);
       }

       return (int)product;
    }
}
        
