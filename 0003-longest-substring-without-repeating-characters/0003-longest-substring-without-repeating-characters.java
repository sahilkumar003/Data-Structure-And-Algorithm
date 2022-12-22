class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        int i=0,j=0,size=0;

        HashMap<Character,Integer> map = new HashMap<>();

        while(i<s.length() && j<s.length()){
            char c = s.charAt(j);
            if(!map.containsKey(c)){
                map.put(c,1);
                size = Math.max(size,j-i+1);
                j++;
            }else{
                char ch = s.charAt(i);
                map.remove(ch);
                i++;
            }
        }
        return size;
        
    }
}