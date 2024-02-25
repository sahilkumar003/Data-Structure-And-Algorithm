class Solution {
    public int reverse(int x) {
        if (x < Integer.MIN_VALUE  || (x > Integer.MAX_VALUE - 1)){
            return 0;
        }
        
        long ans = 0;
        boolean flag = false;
        
        if(x<0){
            x = -(x);
            flag = true;
        }
        
        while(x>0){
                ans *= 10;
                int temp = x%10;
                ans += temp;
                x = x/10;
            }
        
        
        ans =  flag ? -(ans) : ans;
         if (ans < Integer.MIN_VALUE  || (ans > Integer.MAX_VALUE - 1)){
            return 0;
        }
        
        return (int)ans;
    }
}