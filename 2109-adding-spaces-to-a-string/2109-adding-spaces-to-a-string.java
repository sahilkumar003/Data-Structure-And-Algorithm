class Solution {
    public String addSpaces(String s, int[] arr) {
        
        StringBuilder str = new StringBuilder(s);
        
        for(int i=0;i<arr.length;++i){
            str.insert(arr[i]+i," ");
        }
        
        return str.toString();
    }
}