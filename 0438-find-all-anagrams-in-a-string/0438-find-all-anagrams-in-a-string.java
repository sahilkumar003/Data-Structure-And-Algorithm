class Solution {
     public boolean checkAns(HashMap<Character,Integer> ans,HashMap<Character,Integer> req){
        for(char c : req.keySet()){
            if(!ans.containsKey(c) || ans.get(c)<req.get(c)){
                return false;
            }
        }
        return true;
    }
    
    public List<Integer> findAnagrams(String s, String p) { 
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character,Integer> req = new HashMap<>();
        HashMap<Character,Integer> ans = new HashMap<>();
        
        if(s.length()<p.length()){
            return list;
        }


        for(int index=0;index<p.length();++index){
            char c = p.charAt(index);
            char c1 = s.charAt(index);
            req.put(c,req.getOrDefault(c,0)+1);
            ans.put(c1,ans.getOrDefault(c1,0)+1);
        }

        if(checkAns(ans,req)){
            list.add(0);
        }


        int i=0;
        int j=p.length();

        while(i<s.length() && j<s.length()){
            if(ans.get(s.charAt(i))==1){
                ans.remove(s.charAt(i));
            }else{
                ans.put(s.charAt(i),ans.get(s.charAt(i))-1);
            }

            ans.put(s.charAt(j),ans.getOrDefault(s.charAt(j),0)+1);

            if(checkAns(ans,req)){
                list.add(i+1);
            }

            i++;
            j++;
        }
        return list;
    }
}