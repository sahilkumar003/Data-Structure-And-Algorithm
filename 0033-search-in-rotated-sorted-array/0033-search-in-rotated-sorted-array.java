class Solution {
    public int binarySearch(int[]arr,int target,int start,int end){
        while(start<=end){
            int mid = start + (end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid]<target){
                start = mid+1;
            }
        }
        return -1;
    }
    public int findPivot(int []arr){
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid-1>=0 && arr[mid]<arr[mid-1]){
                return mid-1;
            }else if(mid+1<=arr.length-1 && arr[mid]>arr[mid+1] ){
                return mid;
            }

            if(arr[mid]>arr[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }

    
    public int search(int[] arr, int target) {
        int pivot = findPivot(arr);
        if(target>arr[arr.length-1]){
            return (binarySearch(arr,target,0,pivot));
        }else{
            return (binarySearch(arr,target,pivot+1,arr.length-1));
        }
    }
}