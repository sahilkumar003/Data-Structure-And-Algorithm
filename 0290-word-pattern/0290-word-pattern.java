class Solution {
    public boolean wordPattern(String pattern, String s) {
//        String []str = s.split(" ");
        
//         if(pattern.length()!=str.length){
//             return false;
//         }
        
//        HashMap<Character,String> map = new HashMap<>();
        

//         for(int i=0;i<pattern.length();++i){
//             char c = pattern.charAt(i);
//             if(map.containsKey(c)){
//                 if(!(map.get(c).equals(str[i]))){
//                     return false;
//                 }
//             }else {
//                 map.put(c, str[i]);
//             }
//         }

//         HashMap<String,Character> map1 = new HashMap<>();

//         for(int i=0;i<pattern.length();++i){
//             char c = pattern.charAt(i);
//             if(map1.containsKey(str[i])){
//                 if(map1.get(str[i])!=c){
//                     return false;
//                 }
//             }else {
//                 map1.put(str[i],c);
//             }
//         }

//         return true;
        
        
        
        
         String[] strSplit = s.split(" ");
        Map<Object,Object> map = new HashMap<>();
        
        if (pattern.length() != strSplit.length) return false;
        
        for (Integer i = 0; i < strSplit.length; i++) {
            if (map.putIfAbsent(pattern.charAt(i),i) != map.putIfAbsent(strSplit[i],i))
            return false;
        }
        return true;
    }
}