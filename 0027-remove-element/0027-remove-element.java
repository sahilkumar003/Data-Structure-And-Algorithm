class Solution {
    public int removeElement(int[] arr, int val) {
        int count = 0;
        int first = 0;
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=val){
            count++;
                arr[first++] = arr[i];
                
            }
        }
        return count;
    }
}