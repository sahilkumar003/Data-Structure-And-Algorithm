class Solution {
    public void merge(int[] arr1, int m, int[] arr2, int n) {
        int p = m-1;
        int q = n-1;
        int i = m+n-1;
        
        while(q>=0){
            if(p>=0 && arr1[p]>arr2[q]){
                arr1[i--] = arr1[p--];
            }else{
                arr1[i--] = arr2[q--];
            }
        }
        System.out.println(Arrays.toString(arr1));
    }
}