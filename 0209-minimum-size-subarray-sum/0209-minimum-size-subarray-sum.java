class Solution {
    public int minSubArrayLen(int target, int[] arr) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int j = 0;
        
        for(int i=0;i<arr.length;++i){
            sum += arr[i];
            while(sum>=target){
                min = Math.min(min,i-j+1);
                sum -= arr[j++];
            }
        }
        
        return min==Integer.MAX_VALUE ? 0 : min;
    }
}