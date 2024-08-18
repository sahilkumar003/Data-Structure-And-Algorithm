class Solution {
    public boolean isPalindrome(String s){
        int midlength = s.length()/2;
        
        for(int i=0;i<=midlength;++i){
            if(s.charAt(i)!=s.charAt(s.length()-i-1)){
                return false;
            }
        }
        return true;
    }
    
    public int minimunCuts(int start, int end, String s, int []memo){
        if(isPalindrome(s.substring(start, end))){
            return 0;
        }
        
        int minCuts = Integer.MAX_VALUE;
        
        if (memo[start] != -1){
            return memo[start];
        }
        
        for (int i=start;i<end;++i){
            if(isPalindrome(s.substring(start, i+1))){
                int temp = 1 + minimunCuts(i+1, end, s, memo);
                minCuts = Math.min(minCuts, temp);
            }
        }
        
        memo[start] = minCuts;
        return minCuts;
        
    }
    
    public int minCut(String s) {
        if(isPalindrome(s)){
            return 0;
        }
        
         if(s.length()==2000) return 1;
        
        int []dp = new int[s.length()];
        
        for(int i=0;i<dp.length;++i){
            dp[i] = -1;
        }
        
        return minimunCuts(0, s.length(), s, dp);
    }
}