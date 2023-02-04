class Solution {
     public int[] nearestSmallLeft(int []arr){            
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = i+1;
            }else{
                ans[i] = i-stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }

    public int[] nearestSmallRight(int []arr){            
        int []ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                ans[i] = arr.length-i;
            }else{
                ans[i] = stack.peek()-i;
            }
            stack.push(i);
        }
        return ans;
    }
    public int maxAreaHistogram(int []arr){
        int max = Integer.MIN_VALUE;
        int []countLeft = nearestSmallLeft(arr);
        int []countRight = nearestSmallRight(arr);

        for(int i=0;i<arr.length;i++){
            int area = (countRight[i]+countLeft[i]-1)*arr[i];
            max = Math.max(max,area);
        }
        return max;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int [][]arr = new int[matrix.length][matrix[0].length];
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                arr[i][j] = matrix[i][j] - '0';
            }
        }
        
        
        int max = Integer.MIN_VALUE;
        int []ans = new int[arr[0].length];

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1){
                    ans[j] += arr[i][j];
                }else {
                    ans[j] = 0;
                }
            }
            max = Math.max(max,maxAreaHistogram(ans));
        }
        return max;
    }
}