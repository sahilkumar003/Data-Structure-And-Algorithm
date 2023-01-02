class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        long ans = 0;
        
        while(start<=end){
            long mid = start + (end-start)/2;
            long temp = mid*mid;
            if(temp == x){
                return (int)mid;
            }
            
            if(temp>x){
                end = mid-1;
            }else{
                ans = mid;
                start = mid+1;
            }
        }
        
        return (int)ans;
    }
}