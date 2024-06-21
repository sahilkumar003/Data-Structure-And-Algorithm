class Solution:
    def maxRob(self, nums: List[int], currentHouse: int, lastPossibleHouse: int, memo: dict):
        if(currentHouse >= lastPossibleHouse):
            return 0;
        
        currentKey = currentHouse;
        
        if currentKey in memo:
            return memo[currentKey];
        
        rob: int = nums[currentHouse] + self.maxRob(nums, currentHouse+2, lastPossibleHouse, memo);
        notRob: int = self.maxRob(nums, currentHouse+1, lastPossibleHouse, memo);
        memo[currentKey] = max(rob, notRob);    
            
        return max(rob, notRob);    
    
    def rob(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0];
        
        memo1 = {}
        memo2 = {}
        startFromFirstHouse: int = self.maxRob(nums, 0, len(nums)-1, memo1);
        startFromSecondHouse: int = self.maxRob(nums, 1, len(nums), memo2);
            
        return max(startFromFirstHouse, startFromSecondHouse);    