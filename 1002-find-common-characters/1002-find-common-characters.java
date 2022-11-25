class Solution {
    public List<String> commonChars(String[] words) {
        
        ArrayList<String> ans = new ArrayList<>();
        
        int[] count = new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);
        
        for(String s : words){
            int []arr = new int[26];
            for(char c : s.toCharArray()){
                arr[c-'a']++;
            }
            
            for(int i=0;i<26;++i){
                count[i] = Math.min(count[i],arr[i]);
            }
        }
        
        for(int i=0;i<26;++i){
            if(count[i]>0){
                while(count[i]>0){
                    ans.add(((char)(i + 'a')) + "");
                    count[i]--;
                }
            }
        }
        
        return ans;
    }
}