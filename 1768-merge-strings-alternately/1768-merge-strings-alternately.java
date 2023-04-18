class Solution {
    public String mergeAlternately(String s1, String s2) {
        int i = 0;
        int j = 0;
        
        String ans = "";
        
        while(i<s1.length() && j<s2.length()){
            ans += s1.charAt(i);
            ans += s2.charAt(j);
            i++;
            j++;
        }
        
        while(i<s1.length()){
            ans += s1.charAt(i);
                i++;
        }
        while(j<s2.length()){
            ans += s2.charAt(j);
                j++;
        }
        return ans;
    }
}