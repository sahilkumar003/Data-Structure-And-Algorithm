class Solution {
    public boolean check(int []arr, int mid, int h){
        int time = 0;
        
        for(int i=0;i<arr.length;++i){
            time += Math.ceil(arr[i] * 1.0/mid);
        }
        
        return time<=h;
    }
    
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = 1000000000;
        int ans = 0;
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(check(piles,mid,h)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        
        return ans;
    }
}