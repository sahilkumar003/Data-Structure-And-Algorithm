class Solution {
     public int checkSpeed(int []arr,int h){
        int count = 0;
        for (int j : arr) {
            count += (int) Math.ceil(j * 1.0 / h);
        }
        return count;
    }
    
    public int minEatingSpeed(int[] arr, int h) {
         
        int start = 0;
        int end = Integer.MIN_VALUE;
        int ans = 0;
        for (int j : arr) {
            end = Math.max(end, j);
        }

        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid==0){
                return ans;
            }
            if(checkSpeed(arr,mid)>h){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }
        }
        return ans;
    }
}