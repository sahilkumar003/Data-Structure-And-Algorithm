class Solution {
    public boolean isPalindrome(String s,int start, int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }

    public List<List<String>> solution(int index, String s,List<String> ds, List<List<String>> ans){
        if(index==s.length()){
            ans.add(new ArrayList<>(ds));
            return ans;
        }

        for(int i=index;i<s.length();++i){
            if(isPalindrome(s,index,i)){
                ds.add(s.substring(index,i+1));
                solution(i+1,s,ds,ans);
                ds.remove(ds.size()-1);
            }
        }

        return ans;
    }
    
    
    public List<List<String>> partition(String s) {
        return solution(0,s,new ArrayList<>(),new ArrayList<>());
    }
}