class Solution {
     public int findLongestSubsequence(int index1, int index2, String text1, String text2, HashMap<String, Integer> memo){
        if(index1==text1.length() || index2==text2.length()){
            return 0;
        }
        
        int ans = 0;
        String currentKey = index1 + " " + index2;
        
        if (memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        if(text1.charAt(index1) == text2.charAt(index2)){
            ans = 1 + findLongestSubsequence(index1+1, index2+1, text1, text2, memo);
        }else{
            int whenNotEqualMoveIndex1 =  findLongestSubsequence(index1+1, index2, text1, text2, memo);                       int whenNotEqualMoveIndex2 =  findLongestSubsequence(index1, index2+1, text1, text2, memo);
            ans = Math.max(whenNotEqualMoveIndex1, whenNotEqualMoveIndex2);
        }
        memo.put(currentKey, ans);
        return ans;
    }
    
    public int longestPalindromeSubseq(String s) {
        String reverse = new StringBuffer(s).reverse().toString();
        return findLongestSubsequence(0, 0, s, reverse, new HashMap<String,Integer>());
    }
}