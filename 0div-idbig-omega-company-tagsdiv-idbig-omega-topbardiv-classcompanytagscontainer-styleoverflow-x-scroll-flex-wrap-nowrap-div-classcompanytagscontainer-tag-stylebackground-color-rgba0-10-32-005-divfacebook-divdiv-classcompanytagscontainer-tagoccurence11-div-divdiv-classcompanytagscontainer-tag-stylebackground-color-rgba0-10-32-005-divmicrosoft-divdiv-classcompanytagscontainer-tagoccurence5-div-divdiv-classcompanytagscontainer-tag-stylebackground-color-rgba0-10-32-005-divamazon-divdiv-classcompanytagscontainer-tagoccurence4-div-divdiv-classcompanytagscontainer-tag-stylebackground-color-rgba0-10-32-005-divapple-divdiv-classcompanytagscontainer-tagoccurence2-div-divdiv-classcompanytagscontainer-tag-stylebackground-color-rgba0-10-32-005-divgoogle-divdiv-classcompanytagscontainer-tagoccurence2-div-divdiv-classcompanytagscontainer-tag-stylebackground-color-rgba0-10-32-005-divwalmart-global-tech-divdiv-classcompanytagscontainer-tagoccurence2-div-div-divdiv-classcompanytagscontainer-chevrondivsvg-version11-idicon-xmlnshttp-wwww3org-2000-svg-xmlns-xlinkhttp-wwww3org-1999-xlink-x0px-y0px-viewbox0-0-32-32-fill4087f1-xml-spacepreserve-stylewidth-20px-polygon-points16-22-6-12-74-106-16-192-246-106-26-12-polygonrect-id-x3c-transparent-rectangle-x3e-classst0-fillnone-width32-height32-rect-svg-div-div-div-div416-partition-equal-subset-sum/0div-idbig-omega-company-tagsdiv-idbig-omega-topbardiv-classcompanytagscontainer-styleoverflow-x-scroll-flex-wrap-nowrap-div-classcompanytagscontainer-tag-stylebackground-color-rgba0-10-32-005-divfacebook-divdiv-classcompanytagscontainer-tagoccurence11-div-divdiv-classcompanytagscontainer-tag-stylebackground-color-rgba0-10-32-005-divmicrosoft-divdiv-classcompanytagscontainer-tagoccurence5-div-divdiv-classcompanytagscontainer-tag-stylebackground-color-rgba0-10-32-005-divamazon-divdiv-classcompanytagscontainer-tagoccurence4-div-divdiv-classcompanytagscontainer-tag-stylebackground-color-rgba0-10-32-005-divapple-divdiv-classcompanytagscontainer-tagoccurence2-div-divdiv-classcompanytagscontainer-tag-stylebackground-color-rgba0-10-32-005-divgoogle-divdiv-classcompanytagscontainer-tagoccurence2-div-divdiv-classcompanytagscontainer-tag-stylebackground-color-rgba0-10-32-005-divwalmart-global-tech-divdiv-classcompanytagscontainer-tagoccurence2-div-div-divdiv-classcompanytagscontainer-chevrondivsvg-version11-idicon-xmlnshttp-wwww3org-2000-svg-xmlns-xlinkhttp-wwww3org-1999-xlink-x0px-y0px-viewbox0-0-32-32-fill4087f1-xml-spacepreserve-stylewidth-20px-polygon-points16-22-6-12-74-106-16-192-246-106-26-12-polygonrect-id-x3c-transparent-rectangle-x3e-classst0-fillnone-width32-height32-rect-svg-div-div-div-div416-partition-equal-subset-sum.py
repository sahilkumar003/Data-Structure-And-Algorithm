class Solution:
    def isPartitionPossible(self, nums, currentIndex, possibleSum, memo):
        if possibleSum == 0:
            return True;
        
        if currentIndex >= len(nums):
            return False;
        
        currentElement = nums[currentIndex];
        
        currentKey = str(currentIndex) + "-" + str(possibleSum);
        
        if currentKey in memo:
            return memo[currentKey];
        
        pickElement = False;
        
        if(currentElement <= possibleSum):
            pickElement = self.isPartitionPossible(nums, currentIndex+1, possibleSum-currentElement, memo);
        notPickElement = self.isPartitionPossible(nums, currentIndex+1, possibleSum, memo);
        
        memo[currentKey] = bool(pickElement or notPickElement);
        
        return bool(pickElement or notPickElement);
    
    def canPartition(self, nums: List[int]) -> bool:
        sum = 0;
        for element in nums:
            sum = sum + element;
        
        if sum % 2 != 0:
            return False
        
        memo = {}
        return self.isPartitionPossible(nums, 0, sum/2, memo);
        