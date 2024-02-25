class Solution {
    public int reverse(int x) {
        if ((x < Math.pow(-2,31)) || (x > (Math.pow(2,31)) - 1)){
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
         if ((ans < Math.pow(-2,31)) || (ans > (Math.pow(2,31)) - 1)){
            return 0;
        }
        
        return (int)ans;
    }
}