class Solution:
    def totalWays(self, nums, currentIndex, currentSum, targetSum, memo):
        if currentIndex == len(nums):
            if currentSum == targetSum:
                return 1;
            return 0;
        
        currentKey = str(currentIndex) + "-" + str(currentSum);
        
        if currentKey in memo:
            return memo[currentKey];
        
        positiveWay = self.totalWays(nums, currentIndex+1, currentSum + nums[currentIndex], targetSum, memo);
        negativeWay = self.totalWays(nums, currentIndex+1, currentSum - nums[currentIndex], targetSum, memo);
        
        memo[currentKey] = positiveWay + negativeWay;
        
        return positiveWay + negativeWay;
        
    
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        memo = {}
        return self.totalWays(nums, 0, 0, target, memo);        