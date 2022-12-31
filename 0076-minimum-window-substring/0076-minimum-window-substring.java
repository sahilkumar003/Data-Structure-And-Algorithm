class Solution {
    public boolean checkAns(HashMap<Character,Integer> required,HashMap<Character,Integer> map){

        for(Character ch : required.keySet()){
            if(!map.containsKey(ch) || map.get(ch)<required.get(ch)){
                return false;
           }
        }
        return true;
    }


    public String check(int length,String s,String t,HashMap<Character,Integer> required){
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<length;++i){
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        if(checkAns(required,map)){
            return s.substring(0,length);
        }

        for(int i=length;i<s.length();++i){
            char c = s.charAt(i-length);

            if(map.get(c)==1){
                map.remove(c);
            }else{
                map.put(c,map.get(c)-1);
            }

            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);

            if(checkAns(required,map)){
                return s.substring(i-length+1,i+1);
            }
        }

        return "";
    }

    public String minWindow(String s, String t) {
        int start = 1;
        int end = s.length();
        StringBuffer ans = new StringBuffer("");

        HashMap<Character,Integer> required = new HashMap<>();
        
        for(int i=0;i<t.length();++i){
            char c = t.charAt(i);
            required.put(c,required.getOrDefault(c,0)+1);
        }

        while(start<=end){
            int mid = start + (end-start)/2;
            String temp = check(mid,s,t,required);

            if(temp != ""){
                ans = new StringBuffer(temp);
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans.toString();
    }
}