class Solution {
    public int strStr(String s, String x) {
       int i=0;
        int j=x.length();

        while(i<s.length() && j<=s.length()){
            if((s.substring(i,j)).equals(x)){
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
}