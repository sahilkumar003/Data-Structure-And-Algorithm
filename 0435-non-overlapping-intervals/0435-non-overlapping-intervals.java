class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        Arrays.sort(arr ,(a,b) -> {
            return a[1] != b[1] ? a[1] - b[1] : a[0] - b[0];
        });
        
        int count = 0;
        int max = arr[0][1];
        
        for(int i=1;i<arr.length;++i){
            if(arr[i][0]>=max){
                max = arr[i][1];
            }else{
                count++;
            }
        }
        
        return count;
    }
}