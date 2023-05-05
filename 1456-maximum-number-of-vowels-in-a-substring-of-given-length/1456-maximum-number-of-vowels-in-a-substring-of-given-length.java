class Solution {
    public boolean isVowel(char c){
        if(c=='a' || c=='e' ||c=='i' ||c=='o' ||c=='u'){
            return true;
        }
        return false;
    }
    
    public int maxVowels(String s, int k) {
        int max = 0;
        int j = 0;
        int vowel = 0;
        
        for(int i=0;i<k;++i){
            char c = s.charAt(i);
            if(isVowel(c)){
                vowel++;
              max = Math.max(max,vowel);
            }
        }
        
        for(int i=k;i<s.length();++i){
            char c = s.charAt(i);
            char ch = s.charAt(j++);
            if(isVowel(ch)){
                vowel--;
            }
            if(isVowel(c)){
                vowel++;
            }
             max = Math.max(max,vowel);
        }
        
        max = Math.max(max,vowel);
        
        return max;
    }
}