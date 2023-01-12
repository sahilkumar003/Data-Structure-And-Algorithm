class Solution {
    int MOD = 1_000_000_007;
    
    public long myPow(long x, long n) {
        if(x==0 || x==1 || n==1){
            return x;
        }
        
        if(n==0){
            return 1;
        }
        
        long temp = myPow(x,n/2);
        temp %= MOD;
        long ans = temp*temp;
        
        if(n%2==0){
            return ans%MOD;
        }else{
            return (ans * x)%MOD;
        }
    }
    
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        
        return (int)((myPow(5,even) * myPow(4,odd))%MOD);
    }
}