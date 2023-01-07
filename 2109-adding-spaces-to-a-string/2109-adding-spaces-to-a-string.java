class Solution {
    public String addSpaces(String s, int[] arr) {
        
        StringBuffer str = new StringBuffer(s);
        
        int count = 0;
        
        for(int i=0;i<arr.length;++i){
            str.insert(arr[i]+count," ");
            count++;
        }
        
        return str.toString();
    }
}