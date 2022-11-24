class Solution {
    public class pair{
        char ch;
        int fr;
        public pair(char ch, int fr) {
            this.ch = ch;
            this.fr = fr;
        }
    }
    
    public String reorganizeString(String s) {
        int []map = new int[26];

        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            map[c-'a']++;
        }

        PriorityQueue<pair> pq = new PriorityQueue<>( (a,b) -> {
            return b.fr - a.fr;
        } );

        for(int i=0;i<26;++i){
            if(map[i]>0){
                pq.add(new pair((char)('a'+i),map[i]));
            }
        }

        StringBuilder ans = new StringBuilder();

        pair hold = pq.remove();
        ans.append(hold.ch);
        hold.fr--;
        while(pq.size()>0){
            pair temp = pq.remove();
            ans.append(temp.ch);
            temp.fr--;
            if(hold.fr>0){
                pq.add(hold);
            }
            hold = temp;
        }

        if(hold.fr>0){
            return "";
        }
        return ans.toString();
    }
}