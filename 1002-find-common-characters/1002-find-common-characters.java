class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<String> list = new ArrayList<>();
        int []minFreq = new int[26];
        Arrays.fill(minFreq,Integer.MAX_VALUE);
        
        for(int i=0;i<words.length;++i){
            int []currCharFreq = new int[26];
            for(char curr : words[i].toCharArray()){
                currCharFreq[curr - 'a']++;
            }
            
            for(int j=0;j<26;++j){
                minFreq[j] = Math.min(minFreq[j],currCharFreq[j]);
            }
        }
        
        for(int i=0;i<26;++i){
            if(minFreq[i]>0){
                while(minFreq[i]>0){
                 list.add((char)(i+'a')+"");   
                  minFreq[i]--;  
                }
            }
        }
        
        return list;
    }
}