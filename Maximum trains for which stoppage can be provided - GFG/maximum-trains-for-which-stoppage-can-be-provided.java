//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
        	String [] str = br.readLine().trim().split(" ");
        	int n = Integer.parseInt(str[0]);
        	int m = Integer.parseInt(str[1]);
        	ArrayList<ArrayList<Integer>> trains = new ArrayList<>();
        	for(int i = 0; i < m; i++) {
        		str = br.readLine().trim().split(" ");
        		ArrayList<Integer> arr = new ArrayList<>();
        		for(int j = 0; j < 3; j++)
        			arr.add(Integer.parseInt(str[j]));
        		trains.add(arr);
        	}
        	Solution obj = new Solution();
        	int res = obj.maxStop(n, m, trains);
        	System.out.println(res);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	int maxStop(int n, int m, ArrayList<ArrayList<Integer>> trains) {
        int [][]arr = new int[trains.size()][3];
        int maxSize = 0;
        
        for(int i=0;i<trains.size();++i){
            arr[i][0] = trains.get(i).get(0);
            arr[i][1] = trains.get(i).get(1);
            arr[i][2] = trains.get(i).get(2);
            maxSize = Math.max(maxSize,trains.get(i).get(2));
        }
        
        Arrays.sort(arr, (a,b) -> {
            return a[2]!=b[2] ? a[2]-b[2] : a[1]-b[1];
        });
        
        int []temp = new int[maxSize];
        int t = 0;
        int max = 0;
        
        for(int i=0;i<arr.length;++i){
            int index = arr[i][2]-1;
            if(temp[index]!=1){
                temp[index] = 1;
                t++;
                max = arr[i][1];
            }else if(temp[index]==1 && arr[i][0]>=max){
                t++;
                max = arr[i][1];
            }
        }
        
        return t;
    }
}