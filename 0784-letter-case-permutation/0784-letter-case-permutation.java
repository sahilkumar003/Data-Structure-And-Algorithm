class Solution {
      public List<String> permutationSpace(String p, String up, ArrayList<String> list){
        if(up.length()==0){
            list.add(p);
            return list;
        }

        char c = up.charAt(0);

        if(Character.isDigit(c)){
            permutationSpace(p+c,up.substring(1),list);
        }else{
                permutationSpace(p+Character.toLowerCase(c),up.substring(1),list);
                permutationSpace(p+Character.toUpperCase(c),up.substring(1),list); 
        }
            
          return list;
    }
    
    public List<String> letterCasePermutation(String s) {
        
        return permutationSpace("",s,new ArrayList<>());
    }
}