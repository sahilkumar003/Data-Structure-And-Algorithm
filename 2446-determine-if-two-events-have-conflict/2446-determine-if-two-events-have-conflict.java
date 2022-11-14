class Solution {
    public boolean haveConflict(String[] s1, String[] s2) {
        
        int a = Integer.parseInt(s1[0].replaceAll("[^0-9]", ""));
        int b = Integer.parseInt(s1[1].replaceAll("[^0-9]", "")); 
        
        int c = Integer.parseInt(s2[0].replaceAll("[^0-9]", ""));
        int d = Integer.parseInt(s2[1].replaceAll("[^0-9]", ""));
        
       if(b<=d && c<=b){
           return true;
       }else if(d<=b && a<=d){
           return true;
       }
        
        return false;
    }
}