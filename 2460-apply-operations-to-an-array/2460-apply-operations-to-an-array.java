class Solution {
    public int[] applyOperations(int[] arr) {
        for(int i =0;i<arr.length-1;i++){
            if(arr[i] == arr[i+1]){
                arr[i] *=2;
                arr[i+1] = 0;
            }         
        }        
        
        int idx =0;
        for(int i =0; i<arr.length;){
            if(arr[i]>0){
                arr[idx] = arr[i];
                idx++;
                i++;
            }
            else{
                i++;
            }
        }
        while(idx<arr.length)
        {
            arr[idx]=0;
            idx++;
        }
        return arr; 
    }
}
