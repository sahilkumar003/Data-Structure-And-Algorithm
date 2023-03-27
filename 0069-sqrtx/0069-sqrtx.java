class Solution {
    public int mySqrt(int x) {
        long start = 0;
        long end = x;
        long ans = 0;
        
        while(start<=end){
            long mid = start + (end-start)/2;
            
            if((mid*mid)==x){
                return (int)mid;
            }else if((mid*mid)<x){
                ans = start;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return (int)end;
    }
}