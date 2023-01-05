class Solution {
    public int findMinArrowShots(int[][] arr) {
         Arrays.sort(arr, (a,b) -> {
            return a[1]-b[1];
        });

        int count = 1;
        int max = arr[0][1];

        for(int i=1;i<arr.length;++i){
            if(max>=arr[i][0] && max<=arr[i][1]){
                continue;
            }else{
                max = arr[i][1];
                count++;
            }
        }
        return count;
    }
}