class Solution {
    public int largestSumAfterKNegations(int[] arr, int k) {
        Arrays.sort(arr);
        long sum = 0;
        long maxOfNegative = Integer.MAX_VALUE;
        long minOfPositive = Integer.MAX_VALUE;
        boolean flag = false;
        
        for(int i=0;i<arr.length;++i){
            if(arr[i]<0 && k>0){
                flag = true;
                arr[i] = Math.abs(arr[i]);
                maxOfNegative = Math.min(maxOfNegative,arr[i]);
                k--;
            }else{
                minOfPositive = Math.min(minOfPositive,arr[i]);
            }
            
            sum += arr[i];
        }
        
        if(k%2!=0){
            if(flag){
                long x = Math.min(maxOfNegative,minOfPositive);
                return (int)(sum-(2*x));
            }else{
                return (int)(sum - (2*minOfPositive));
            }
        }
        
        return (int)sum;
    }
}