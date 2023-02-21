class Solution {
     public int findSquare(int number){
        int ans = 0;
        
        while(number>0){
            int rem = number%10;
            ans += rem*rem;
            number /= 10;
        }
        
        return ans;
    }
    
    public boolean isHappy(int n) {
        
         int slow = n;
         int fast = n;
         
         do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
            
            if(slow==1){
                return true;
            }
         }while(slow!=fast);
         
         return false;
    }
}