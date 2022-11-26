class Solution {
    public boolean isPalindrome(String str) {
         str = str.replaceAll("[^a-zA-Z0-9]", "");
        str = str.toLowerCase();
        int j = str.length()-1;
        
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(j-i)){
                return false;
            }
        }
        return true;
    }
}