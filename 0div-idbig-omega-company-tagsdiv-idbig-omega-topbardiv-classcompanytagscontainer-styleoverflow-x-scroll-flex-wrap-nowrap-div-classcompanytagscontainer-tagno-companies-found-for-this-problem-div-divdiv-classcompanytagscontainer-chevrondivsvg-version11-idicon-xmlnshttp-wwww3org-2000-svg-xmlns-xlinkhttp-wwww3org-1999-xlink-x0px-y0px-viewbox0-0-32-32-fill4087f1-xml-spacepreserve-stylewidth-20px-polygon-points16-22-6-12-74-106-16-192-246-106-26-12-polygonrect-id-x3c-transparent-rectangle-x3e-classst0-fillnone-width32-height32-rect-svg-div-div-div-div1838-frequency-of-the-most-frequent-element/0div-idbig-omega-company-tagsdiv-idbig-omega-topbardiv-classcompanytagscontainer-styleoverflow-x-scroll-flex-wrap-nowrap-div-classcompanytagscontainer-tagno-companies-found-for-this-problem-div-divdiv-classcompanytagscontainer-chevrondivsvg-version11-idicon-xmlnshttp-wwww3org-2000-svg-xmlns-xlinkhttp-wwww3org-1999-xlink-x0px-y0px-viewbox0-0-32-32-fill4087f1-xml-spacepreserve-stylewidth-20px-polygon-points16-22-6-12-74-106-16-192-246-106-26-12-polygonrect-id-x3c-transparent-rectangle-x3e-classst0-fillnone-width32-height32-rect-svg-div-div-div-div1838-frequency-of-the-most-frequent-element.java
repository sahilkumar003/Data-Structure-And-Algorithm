class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int leftPointer = 0;
        int maximumPossibleFrequency = 1;
        long windowSum = 0;
        
        for(int rightPointer=0;rightPointer<nums.length;rightPointer++){
            windowSum += nums[rightPointer];
            
            while((long) nums[rightPointer] * (rightPointer - leftPointer + 1) > windowSum + k){
                windowSum -= nums[leftPointer];
                leftPointer++;
            }
            
            maximumPossibleFrequency = Math.max(maximumPossibleFrequency, rightPointer - leftPointer + 1);
        }
        
        return maximumPossibleFrequency;
    }
}