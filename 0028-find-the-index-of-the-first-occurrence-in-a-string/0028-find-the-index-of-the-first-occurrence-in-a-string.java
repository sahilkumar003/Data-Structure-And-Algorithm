class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }
        
        int i=0,j=0,index=-1;
        
        while(i<haystack.length() && j<needle.length()){
            if(haystack.charAt(i)!=needle.charAt(j)){
                i++;
            }else{
                index = i;
                while(i<haystack.length() && j<needle.length() && haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }
                if(j==needle.length()){
                    return index;
                }else{
                    i = index+1;
                    j = 0;
                    index = -1;
                }
            }
        }
        return -1;
        
    }
}