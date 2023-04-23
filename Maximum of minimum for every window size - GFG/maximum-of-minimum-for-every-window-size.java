//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String[] inputline = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputline[0]);
            inputline = br.readLine().trim().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputline[i]);
            }
            Solution ob =new Solution();
            int[] res = ob.maxOfMin(arr, n);
            
            for (int i = 0; i < n; i++) 
                System.out.print (res[i] + " ");
            System.out.println ();
        }
    }
}
// } Driver Code Ends



class Solution 
{
    public static int[] rightMin(int []arr){
        int []rightMin = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=arr.length-1;i>=0;--i){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                rightMin[i] = arr.length - i;
            }else{
                rightMin[i] = stack.peek() - i;
            }
            
            stack.push(i);
        }
        return rightMin;
    }

    public static int[] leftMin(int []arr){
        int []leftMin = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0;i<arr.length;++i){
            while(!stack.isEmpty() && arr[i]<=arr[stack.peek()]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                leftMin[i] = i+1;
            }else{
                leftMin[i] = i-stack.peek();
            }
            
            stack.push(i);
        }
        return leftMin;
    }
    
    static int[] maxOfMin(int[] arr, int n) 
    {
        int []rightM = rightMin(arr);
        int []leftM = leftMin(arr);
        int []ans = new int[arr.length];
        
        for(int i=0;i<arr.length;++i){
            int index = (rightM[i] + leftM[i] - 1);
            ans[index-1] = Math.max(arr[i],ans[index-1]);
        }
        
        for(int i=arr.length-2;i>=0;--i){
            if(ans[i]<ans[i+1]){
                ans[i] = ans[i+1];
            }
        }
       

        return ans;
    }
}