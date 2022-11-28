class Solution {
     public int search(int []arr,int target,int start ,int end){

        if(start>end){
            return -1;
        }

        int mid = start + (end-start)/2;

        if(arr[mid] == target){
            return mid;
        }

        if(arr[mid]>=arr[start]){
            if(target<=arr[mid] && target>=arr[start]){
                return search(arr,target,start,mid-1);
            }else{
                return search(arr,target,mid+1,end);
            }
        }else {
            if (target >= arr[mid] && target <= arr[end]) {
                return search(arr, target, mid + 1, end);
            }else{
                return search(arr,target,start,mid-1);
            }
        }
    }
    
    public int search(int[] arr, int target) {
        
        return search(arr,target,0,arr.length-1);
    }
}