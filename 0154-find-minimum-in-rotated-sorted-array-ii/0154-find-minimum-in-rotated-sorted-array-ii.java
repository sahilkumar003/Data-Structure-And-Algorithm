class Solution {
    public int findMin(int[] arr) {
        int start = 0;
        int end = arr.length-1;
        int pivot = findPivot(arr,start,end);
        if(pivot==-1){
            return arr[0];
        }
        return arr[pivot];
    }
    
    public int findPivot(int []arr,int start,int end){
        while(start<end){
            int mid = start + (end-start)/2;
            if(arr[mid]>arr[end]){
                start = mid+1;
            }else if(arr[mid]<arr[end]){
                end = mid;
            }else{
                end--;
            }
        }
        return end;
    }
}