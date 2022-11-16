class Solution {
    public int maximumProduct(int[] arr) {
//         Arrays.sort(arr);
//         int n = arr.length-1;
        
//         return Math.max(arr[0]*arr[1]*arr[n] ,arr[n]*arr[n-1]*arr[n-2]);
        
        
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int i=0;i<arr.length;++i){
            
            if(arr[i]>max1){
                max3 = max2;
                max2 = max1;
                max1 = arr[i];
            }else if(arr[i]>max2){
                max3 = max2;
                max2 = arr[i];
            }else if(arr[i]>max3){
                max3 = arr[i];
            }
            
            if(min1>arr[i]){
                min2 = min1;
                min1 = arr[i];
            }else if(min2>arr[i]){
                min2 = arr[i];
            }
        }
        
        return Math.max(max1*max2*max3 , min1*min2*max1);
    }
}