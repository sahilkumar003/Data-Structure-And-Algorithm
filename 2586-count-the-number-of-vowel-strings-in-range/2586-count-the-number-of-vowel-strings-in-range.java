class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0 ;
        for(int i = left ; i<=right ; i++){
            String a = words[i];
            if((a.charAt(0)== 'a' || a.charAt(0)== 'e' || a.charAt(0)== 'i' || a.charAt(0)== 'o' || a.charAt(0) =='u') && (a.charAt(a.length()-1)== 'a' || a.charAt(a.length()-1)== 'e' || a.charAt(a.length()-1)== 'i' || a.charAt(a.length()-1)== 'o' || a.charAt(a.length()-1) =='u') ){
                count++;
            }
        }
        return count;
    }
}