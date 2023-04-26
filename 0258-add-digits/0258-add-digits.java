class Solution {
    public int addDigits(int n) {
        int sum = 0;
        if(n==0){
            return 0;
        }
        
        while(n>0){
            int last = n%10;
            sum = sum + last;
            n = n/10;
            if(n==0){
                n = sum;
                if(n>=1 && n<=9){
                    return n;
                }
                sum = 0;
            }
        }
        return 0;
    }
}