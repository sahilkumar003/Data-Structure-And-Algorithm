class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int []arr = new int[2*n];
        int one = 0;
        
        for(int i=0;i<2*n;++i){
            arr[i] = nums[i%nums.length];
            if(i<nums.length && arr[i]==1){
                one++;
            }
        }
        
        if(one == 0){
            return 0;
        }
    
        int zero = 0;
        int min = Integer.MAX_VALUE;
        
        int j = 0;
        
        for(int i=0;i<2*n;++i){  
            if(i>=one){
                min = Math.min(min,zero);
                if(arr[j++]==0){
                    zero--;
                }
            }
            if(arr[i]==0){
                zero++;
            }
        }
        
        return (int)Math.min(min,zero);
        
    }
}