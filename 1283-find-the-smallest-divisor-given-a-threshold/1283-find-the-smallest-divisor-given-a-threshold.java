class Solution {
    public int sum(int []arr, int divisor){
        int sum = 0;
        for(int i=0;i<arr.length;++i){
            int temp = ((arr[i]-1)/divisor) + 1;
            sum += temp;
        }
        return sum;
    }
    
    public int smallestDivisor(int[] arr, int threshold) {
        int start = 1;
        int end = 1000000;
        int ans = 0;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(sum(arr,mid)<=threshold){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}