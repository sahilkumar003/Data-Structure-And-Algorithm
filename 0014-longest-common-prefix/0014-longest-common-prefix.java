class Solution {
    public String longestCommonPrefix(String[] str) {
        if(str.length == 0){
            return "";
        }
        
        String ans = "";
        int counter = 0;
        
        for(char c : str[0].toCharArray()){
            for(int i=1;i<str.length;++i){
                if(counter>=str[i].length() || str[i].charAt(counter)!=c){
                    return ans;
                }
            }
            counter++;
            ans += c;
        }
        
        return ans;
    }
}