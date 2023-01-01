class Solution {
    public boolean wordPattern(String pattern, String s) {
        String []str = s.split(" ");
        HashMap<Character,String> map = new HashMap<>();
        
        if(pattern.length()!=str.length){
            return false;
        }

        for(int i=0;i<pattern.length();++i){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!(map.get(c).equals(str[i]))){
                    return false;
                }
            }else {
                map.put(c, str[i]);
            }
        }
        
        for(int i=1;i<pattern.length();++i){
            if(pattern.charAt(i)!=pattern.charAt(i-1)){
                if((str[i]).equals(str[i-1])){
                    return false;
                }
            }
        }
        
        if(pattern.charAt(0)!=pattern.charAt(pattern.length()-1)){
            if((str[0]).equals(str[str.length-1])){
                return false;
            }
        }

        return true;
    }
}