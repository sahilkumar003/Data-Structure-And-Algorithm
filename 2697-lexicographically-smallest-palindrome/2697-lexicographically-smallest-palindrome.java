class Solution {
    public String makeSmallestPalindrome(String s) {
     char []arr = s.toCharArray();
        
        for(int i=0;i<=arr.length/2;++i){
            int j = arr.length-1-i;
            if(arr[i]>arr[j]){
                arr[i] = arr[j];
            }else if(arr[i]<arr[j]){
                arr[j] = arr[i];
            }else{
                continue;
            }
        }
        
        String ans = "";
        
        for(int i=0;i<arr.length;++i){
            ans += arr[i];
        }
        
        return ans;
    }
}