class Solution:
    def maxRob(self, nums: List[int], currentHouse: int, memo: dict) -> int:
        if currentHouse >= len(nums):
            return 0;
        
        currentKey = currentHouse;
        
        if currentKey in memo:
            return memo[currentKey];
        
        robbed = nums[currentHouse] + self.maxRob(nums, currentHouse+2, memo);
        notRobbed = self.maxRob(nums, currentHouse+1, memo);
        
        memo[currentKey] = max(robbed, notRobbed);
        
        return max(robbed, notRobbed);
        
    
    def rob(self, nums: List[int]) -> int:
        memo = {}
        return self.maxRob(nums, 0, memo);
        