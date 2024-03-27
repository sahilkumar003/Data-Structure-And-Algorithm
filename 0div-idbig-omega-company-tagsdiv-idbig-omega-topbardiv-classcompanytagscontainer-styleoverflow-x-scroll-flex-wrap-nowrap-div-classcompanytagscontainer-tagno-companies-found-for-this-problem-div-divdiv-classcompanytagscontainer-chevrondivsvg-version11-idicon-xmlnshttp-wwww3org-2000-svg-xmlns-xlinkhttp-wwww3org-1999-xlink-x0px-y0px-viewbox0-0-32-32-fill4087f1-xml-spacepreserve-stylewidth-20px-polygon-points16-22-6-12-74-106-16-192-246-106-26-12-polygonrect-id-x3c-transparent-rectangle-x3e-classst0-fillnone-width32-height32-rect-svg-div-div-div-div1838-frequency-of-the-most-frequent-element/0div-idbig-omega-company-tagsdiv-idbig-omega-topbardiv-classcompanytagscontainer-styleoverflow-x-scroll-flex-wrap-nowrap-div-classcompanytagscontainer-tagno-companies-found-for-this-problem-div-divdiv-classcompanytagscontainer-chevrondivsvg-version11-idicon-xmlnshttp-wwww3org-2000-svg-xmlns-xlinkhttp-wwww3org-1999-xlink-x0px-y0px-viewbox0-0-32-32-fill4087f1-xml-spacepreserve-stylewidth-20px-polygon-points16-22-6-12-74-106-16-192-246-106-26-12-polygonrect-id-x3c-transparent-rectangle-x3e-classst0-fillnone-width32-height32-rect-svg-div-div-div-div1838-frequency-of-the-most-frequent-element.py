class Solution:
    def maxFrequency(self, nums: List[int], k: int) -> int:
        nums.sort();
        
        leftPointer = 0;
        maximumPossibleFrequency = 1;
        windowSum = 0;
        
        for rightPointer in range(len(nums)):
            windowSum += nums[rightPointer];
            
            while nums[rightPointer] * (rightPointer - leftPointer + 1) > windowSum + k:
                windowSum -= nums[leftPointer];
                leftPointer += 1
            
            maximumPossibleFrequency = max(maximumPossibleFrequency, rightPointer - leftPointer + 1);
        
        
        return maximumPossibleFrequency;
        