class Solution {
    public int pivotIndex(int[] arr) {
        int []prefix = new int[arr.length];
        int []suffix = new int[arr.length];
        int sum = 0;
        
        for(int i=0;i<arr.length;++i){
            sum += arr[i];
            prefix[i] = sum;
        }
        
        sum = 0;
        for(int i=arr.length-1;i>=0;--i){
            sum += arr[i];
            suffix[i] = sum;
        }
        
        for(int i=0;i<arr.length;++i){
            if(prefix[i]==suffix[i]){
                return i;
            }
        }
        
        return -1;
    }
}