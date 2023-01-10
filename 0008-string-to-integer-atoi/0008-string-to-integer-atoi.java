class Solution {
    public int myAtoi(String s) {
        
        if(s.length()==0){
            return 0;
        }
        
        int index = 0;
        
        while((index<s.length()) && (s.charAt(index) == ' ')){
            index++;
        }
        
        boolean neg = false;
        
        if (index < s.length()) {
            if (s.charAt(index) == '-') {
                neg = true;
                ++index;
            } else if (s.charAt(index) == '+'){
                ++index;
            }
        }
        
        int ans = 0;
        
        while(index<s.length() && Character.isDigit(s.charAt(index))){
            int temp = s.charAt(index)-'0';
            
            if (ans > (Integer.MAX_VALUE / 10) || (ans == (Integer.MAX_VALUE / 10) && temp > 7)){
                return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            
            ans = ans*10 + temp;
            
            index++;
        }
        
        
        return neg ? -ans : ans;
        
    }
}