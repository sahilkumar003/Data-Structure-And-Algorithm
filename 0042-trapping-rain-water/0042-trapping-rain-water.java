class Solution {
      public int[] left_max(int []arr){
        int []temp = new int[arr.length];
        int max = arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max = arr[i];
                temp[i] = max;
            }else{
                temp[i] = max;
            }
        }
        return temp;
    }

    public int[] right_max(int []arr){
        int []temp = new int[arr.length];
        int max = arr[arr.length-1];
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>max){
                max = arr[i];
                temp[i] = max;
            }else{
                temp[i] = max;
            }
        }
        return temp;
    }

    
    public int trap(int[] arr) {
          int []leftMax = left_max(arr);
        int []rightMax = right_max(arr);
        int sum = 0;

        for(int i=0;i<arr.length;i++){
            sum += (Math.min(leftMax[i],rightMax[i]) - arr[i]);
        }
         return sum;
    }
}