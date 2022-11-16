class Solution {
    public int maxProduct(int[] arr) {
         int max1 = Integer.MIN_VALUE;
         int max2 = Integer.MIN_VALUE;
        
         
        for(int i=0;i<arr.length;++i){  
            if(arr[i]>max1){
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i]>max2){
                max2 = arr[i];
            }
        }
        
        return ((max1-1)*(max2-1));
    }
}