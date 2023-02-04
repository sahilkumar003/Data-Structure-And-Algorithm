class Solution {
    public int[] leftMax(int []arr){
        Stack<Integer> stack = new Stack<>();
        int []ans = new int[arr.length];
        
        for(int i=0;i<arr.length;++i){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                ans[i] = 0;
                stack.push(i);
            }else{
                ans[i] = arr[stack.peek()];
            }
        }
        
        return ans;
    }
    
    public int[] rightMax(int []arr){
        Stack<Integer> stack = new Stack<>();
        int []ans = new int[arr.length];
        
        for(int i=arr.length-1;i>=0;--i){
            while(!stack.isEmpty() && arr[i]>=arr[stack.peek()]){
                stack.pop();
            }
            
            if(stack.isEmpty()){
                ans[i] = 0;
                stack.push(i);
            }else{
                ans[i] = arr[stack.peek()];
            }
        }
        
        return ans;
    }
        
    public int trap(int[] height) {
       int []leftMax = leftMax(height);
       int []rightMax = rightMax(height);
       int ans = 0;
        
       for(int i=1;i<height.length-1;++i){
           int temp = Math.min(leftMax[i],rightMax[i]);
           int water = temp - height[i];
           
           if(water>0){
               ans += water;
           }
       } 
        return ans;
    }
}