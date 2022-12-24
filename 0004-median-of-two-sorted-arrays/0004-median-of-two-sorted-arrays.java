class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
         if(arr2.length<arr1.length){
            return findMedianSortedArrays(arr2,arr1);
        }
        
        int n1 = arr1.length;
        int n2 = arr2.length;

        int start = 0;
        int end = arr1.length;

        while(start<=end){
            int cut1 = start + (end-start)/2;
            int cut2 = (n1+n2+1)/2-cut1;

            int l1 = cut1 == 0 ? Integer.MIN_VALUE : arr1[cut1-1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : arr2[cut2-1];
            int r1 =  cut1 == n1 ? Integer.MAX_VALUE : arr1[cut1];
            int r2 =  cut2 == n2 ?  Integer.MAX_VALUE : arr2[cut2];

            while(l1<=r2 && l2<=r1){
                if((n1+n2)%2==0){
                    return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2;
                }else{
                    return (double)(Math.max(l1,l2));
                }
            }

            if(l1>r2){
                end = cut1-1;
            }else{
                start = cut1+1;
            }
        }
        return 0.0;
    }
}