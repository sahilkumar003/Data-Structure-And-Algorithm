class Solution {
    public String longestCommonPrefix(String[] s) {
         String prefix = s[0];
        String ans = "";

        for(int i=0;i<prefix.length();++i){
            for(int j=1;j<s.length;++j){
                if(i>(s[j].length()-1) || s[j].charAt(i)!=prefix.charAt(i)){
                    return ans;
                }
            }
            ans += prefix.charAt(i);
        }

        return ans;
    }
}