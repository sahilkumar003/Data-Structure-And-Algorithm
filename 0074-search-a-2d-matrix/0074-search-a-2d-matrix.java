class Solution {
    public boolean searchMatrix(int[][] arr, int target) {
        int row = arr.length;
        int col = arr[0].length;

        int start = 0;
        int end = row*col-1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid/col][mid%col]==target){
                return true;
            }else if(arr[mid/col][mid%col]<target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
}