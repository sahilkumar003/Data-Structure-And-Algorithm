class Solution {
    public int minSubArrayLen(int k, int[] arr) {
        int i=0,j=0,sum=0,size=Integer.MAX_VALUE;
        
        while(i<arr.length && j<arr.length){
            sum += arr[j++];
                while(sum>=k){
                    size = Math.min(size,j-i);
                    sum -= arr[i++];
                }
        }
        return size==Integer.MAX_VALUE?0:size;
    }
}