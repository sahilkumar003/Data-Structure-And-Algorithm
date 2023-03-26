class Solution {
    // public boolean check( HashMap<Character,Integer> map, HashMap<Character,Integer> require){
    //     for(char c : map.keySet()){
    //         if(require.containsKey(c)){
    //             if(map.get(c)!=require.get(c)){
    //                 return false;
    //             }
    //         }else{
    //             return false;
    //         }
    //     }
    //     return true;
    // }
    
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character,Integer> map = new HashMap<>();
        HashMap<Character,Integer> require = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        
        for(int i=0;i<p.length();++i){
            char c = p.charAt(i);
            require.put(c,require.getOrDefault(c,0)+1);
        }
        
        int j = -1;
        
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            
            if(i>=p.length()){
                if(map.equals(require)){
                    list.add(i-p.length());
                }
                
                char ch = s.charAt(++j);
                if(map.get(ch)<=1){
                    map.remove(ch);
                }else{
                    map.put(ch,map.get(ch)-1);
                }
            }
            
            map.put(c,map.getOrDefault(c,0)+1);
        }
        
        if(map.equals(require)){
            list.add(s.length()-p.length());
        }
        
        return list;
    }
}