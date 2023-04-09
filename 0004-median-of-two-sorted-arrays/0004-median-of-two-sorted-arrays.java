class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int []ans = new int[arr1.length + arr2.length];
        
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                ans[k++] = arr1[i];
                i++;
            }else{
                ans[k++] = arr2[j];
                j++;
            }
        }
        
        while(i<arr1.length){
            ans[k++] = arr1[i++];
        }
        
        while(j<arr2.length){
            ans[k++] = arr2[j++];
        }
        
        if(ans.length%2 == 0){
            return (double)((double)ans[ans.length/2] + (double)ans[ans.length/2 - 1]) / 2;
        }else{
            return (double)ans[ans.length/2];
        }
        
    }
}