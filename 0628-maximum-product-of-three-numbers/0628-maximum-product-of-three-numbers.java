class Solution {
    public int maximumProduct(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length-1;
        
        return Math.max(arr[0]*arr[1]*arr[n] ,arr[n]*arr[n-1]*arr[n-2]);
        
    }
}