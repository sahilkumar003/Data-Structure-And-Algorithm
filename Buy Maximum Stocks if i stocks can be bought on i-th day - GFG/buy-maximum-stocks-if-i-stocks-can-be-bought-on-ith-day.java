//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        int [][]arr = new int[n][n];
        
        for(int i=0;i<n;++i){
            arr[i][0] = price[i];
            arr[i][1] = i+1;
        }
        
        Arrays.sort(arr, (a,b) -> {
            return a[0] - b[0];
        });
        
        int count = 0;
        int temp = k;
        for(int i=0;i<n;++i){
            for(int j=0;j<arr[i][1];++j){
                temp -= arr[i][0];
                if(temp>=0){
                    count++;
                }else{
                    return count;
                }
            }
        }
        
        return count;
    }
}
        
