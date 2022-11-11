class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        int n = s.length();
        for(int i = 0;i<n;i++){
            int len = 1;
            int left = i-1;
            int right= i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                len+=2;
                left--;
                right++;
            }
            if(len > max){
                start = left + 1;
                 end = right - 1; 
                max = len;
            }
        }
        int len2=0;
        
        for(int i = 0;i<n;i++){
            len2 = 0;
            int left = i;
            int right= i + 1;
            while(left >= 0 && right < n && s.charAt(left) == s.charAt(right)){
                len2+=2;
                left--;
                right++;
            }
            if(len2 > max){
                start = left + 1;
                 end = right - 1; 
                max = len2;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = start; i<= end;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}