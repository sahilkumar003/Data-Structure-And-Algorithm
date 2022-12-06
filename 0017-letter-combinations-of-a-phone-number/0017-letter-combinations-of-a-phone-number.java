class Solution {
    public ArrayList<String> phonePair(String p, String up, ArrayList<String>list){
        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        int digit = up.charAt(0) - '0';
        if(digit==7){
         for(int i=15;i<=18;++i){
            if(i==26){
                continue;
            }
            char ch = (char) (i+'a');
            phonePair(p+ch,up.substring(1),list);
            }
        }else if(digit==8){
        for(int i=19;i<=21;++i){
            if(i==26){
                continue;
            }
            char ch = (char) (i+'a');
            phonePair(p+ch,up.substring(1),list);
            }
        }else if(digit==9){
        for(int i=22;i<=25;++i){
            char ch = (char) (i+'a');
            phonePair(p+ch,up.substring(1),list);
            }
        }
        else{
         for(int i=(digit-2)*3;i<(digit-1)*3;++i){
            if(i==26){
                continue;
            }
            char ch = (char) (i+'a');
            phonePair(p+ch,up.substring(1),list);
           }
        }
        
        return list;
    }
    
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return new ArrayList<String>();
        }
        ArrayList<String> list = new ArrayList<>();
        return phonePair("",digits,list);
    }
}