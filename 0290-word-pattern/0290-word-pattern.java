class Solution {
    public boolean wordPattern(String pattern, String s) {
       String []str = s.split(" ");
        
        if(pattern.length()!=str.length){
            return false;
        }
        
       HashMap<Character,String> map = new HashMap<>();
        

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

        HashMap<String,Character> map1 = new HashMap<>();

        for(int i=0;i<pattern.length();++i){
            char c = pattern.charAt(i);
            if(map1.containsKey(str[i])){
                if(map1.get(str[i])!=c){
                    return false;
                }
            }else {
                map1.put(str[i],c);
            }
        }

        return true;
    }
}