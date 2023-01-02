class Solution {
    public boolean detectCapitalUse(String s) {
        if(s.length() == 1){
            return true;
        }
        
        boolean lower = false;
        boolean upper = false;
        boolean first = false;
        
        if(Character.isUpperCase(s.charAt(0))){
            first = true;
        }
        
        for(int i=1;i<s.length();++i){
            char c = s.charAt(i);
            if(Character.isLowerCase(c)){
                lower = true;
            }
            if(Character.isUpperCase(c)){
                upper = true;
            }
        }
        
        if((first && upper && !lower) || (!first && !upper && lower) || (first && !upper && lower)){
            return true;
        }
        
        return false;
    }
}