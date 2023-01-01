class Solution {
    public int titleToNumber(String s) {
        int ans = 0;
        int k = 0;
        
        for(int i=s.length()-1;i>=0;--i){
            int temp = (int)(s.charAt(i) - 'A') + 1; 
            ans += temp * Math.pow(26,k);
            k++;
        }
        
        return ans;
    }
}