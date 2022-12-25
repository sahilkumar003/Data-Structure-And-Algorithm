class Solution {
    public String longestCommonPrefix(String[] s) {
         if (s == null || s.length == 0){
            return "";
            }
        
        Arrays.sort(s);
        
        String prefix = s[0];
        String ans = "";

        for(int i=0;i<prefix.length();++i){
            for(int j=1;j<s.length;++j){
                if(s[j].charAt(i)!=prefix.charAt(i)){
                    return ans;
                }
            }
            ans += prefix.charAt(i);
        }

        return ans;
    }
}