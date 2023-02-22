class Solution {
    public int shipWithinDays(int[] arr, int days) {
         int start = 1;
        int end = 25000000;
        int ans = 0;
        int sumArray = 0;
         int max = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            max = Math.max(max,arr[i]);
            sumArray += arr[i];
        }
        
        if(days==1){
            return sumArray;
        }

        while(start<=end){
            int mid = start + (end-start)/2;
            int sum = 0;
            int day = 1;

            for(int i=0;i<arr.length;i++){
                sum += arr[i];
                if(sum>mid){
                    day++;
                    sum = arr[i];
                }
            }
            if(day>days){
                start = mid+1;
            }else{
                ans = mid;
                end = mid-1;
            }

        }
        return (ans<max)?max:ans;
    }
}