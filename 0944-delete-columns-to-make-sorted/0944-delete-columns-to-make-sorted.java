class Solution {
    public int minDeletionSize(String[] s) {
        int count = 0;
        for(int i=0;i<s[0].length();++i){
            for(int j=1;j<s.length;++j){
                if((s[j].charAt(i))<(s[j-1].charAt(i))){
                    count++;
                    break;
                }
            }
        }
        
        return count;
    }
}