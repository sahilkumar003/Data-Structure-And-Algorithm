class Solution {
    public int minDays(int[] arr, int m, int k) {
        if(arr.length < m*k){
            return -1;
        }
        
        int start = Integer.MAX_VALUE;
        int end = 0;
        int ans = -1;
        
        for(int i=0;i<arr.length;++i){
            start = Math.min(start,arr[i]);
            end = Math.max(end,arr[i]);
        }
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            int count = 0;
            int buq = 0;
            
            for(int i=0;i<arr.length;++i){
                if(arr[i]<=mid){
                    count++;
                    if(count==k){
                        buq++;
                        count = 0;
                    }
                }else{
                    count = 0;
                }
            }
            
            if(buq>=m){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
            
        }
        return ans;
    }
}