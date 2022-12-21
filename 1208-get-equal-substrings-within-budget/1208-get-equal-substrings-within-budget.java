class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int []arr = new int[s.length()];
        
        for(int i=0;i<arr.length;++i){
            int temp = (int)(s.charAt(i)-t.charAt(i));
            arr[i] = Math.abs(temp);
        }
        
        int max = 0;
        int j = 0;
        
        for(int i=0;i<arr.length;++i){     
            while(j<i && arr[i]>maxCost){
                maxCost += arr[j++];
            }
             maxCost -= arr[i];
            if(maxCost>=0){
                max = Math.max(max,(i-j+1));
            }
        }
        
        return max;
    }
}