class Solution {
    public int strStr(String s1, String s2) {
       int i = 0;
        int j = 0;
        int ans = -1;
        
        while(i<s1.length()){
            while(i<s1.length() && s1.charAt(i)!=s2.charAt(j)){
                i++;
            }
            if(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j)){
                ans = i;
                while(i<s1.length() && j<s2.length() && s1.charAt(i)==s2.charAt(j)){
                    i++;
                    j++;
                }
                
                if(j==s2.length()){
                    return ans;
                }else{
                    j = 0;
                    i = ans+1;
                }
            }
        }
        
        return j==s2.length() ? ans : -1;
    }
}