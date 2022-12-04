class Solution {
    public int minimumAverageDifference(int[] arr) {
        if(arr.length==1){
            return 0;
        }

        long []prefix = new long[arr.length];
        long []suffix = new long[arr.length];
        long sum1 = 0;
        long sum2 = 0;

        for(int i=0;i<arr.length;++i){
            sum1 += arr[i];
            sum2 += arr[arr.length-i-1];

            prefix[i] = sum1;
            suffix[arr.length-1-i] = sum2;
        }

        sum1 = 0;
        sum2 = 0;
        long temp = 0;
        long ans = 0;
        long min = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;++i){
            sum1 = prefix[i]/(i+1);
            sum2 = suffix[i+1]/(arr.length-i-1);

            temp = Math.abs(sum1-sum2);

            if(temp<min){
                min = temp;
                ans = i;
            }
        }

        temp = prefix[arr.length-1]/arr.length;

        if(temp<min) {
            ans = arr.length - 1;
        }

        return (int)ans;
    }
}