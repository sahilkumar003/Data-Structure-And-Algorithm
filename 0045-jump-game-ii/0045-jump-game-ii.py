class Solution:
    def canReachEnd(self, nums, currentIndex, target, memo):
        if currentIndex >= target:
            return 0;
        
        if nums[currentIndex] == 0:
            return 10001
        
        ans = 10001;
        
        currentKey = currentIndex;
        
        if currentKey in memo:
            return memo[currentKey];
        
        for i in range(1, nums[currentIndex]+1):
            tempAns = 1 + self.canReachEnd(nums, currentIndex+i, target, memo);
            ans = min(ans,tempAns);
            memo[currentKey] = ans;
            
        return ans;
    
    def jump(self, nums: List[int]) -> int:
        return self.canReachEnd(nums, 0, len(nums)-1, dict());
        