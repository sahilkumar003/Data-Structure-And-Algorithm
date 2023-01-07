class Solution {
    public String addSpaces(String s, int[] arr) {
        
        StringBuffer str = new StringBuffer(s);
        
        for(int i=0;i<arr.length;++i){
            str.insert(arr[i]+i," ");
        }
        
        return str.toString();
    }
}