class Solution {
    public int arraySign(int[] nums) {
        int zero = 0;
        int neg = 0;
        
        for(int i=0;i<nums.length;++i){
            if(nums[i]==0){
                zero++;
            }else if(nums[i]<0){
                neg++;
            }
        }
        
        return zero>0 ? 0 : neg%2==0 ? 1 : -1;
      
    }
}