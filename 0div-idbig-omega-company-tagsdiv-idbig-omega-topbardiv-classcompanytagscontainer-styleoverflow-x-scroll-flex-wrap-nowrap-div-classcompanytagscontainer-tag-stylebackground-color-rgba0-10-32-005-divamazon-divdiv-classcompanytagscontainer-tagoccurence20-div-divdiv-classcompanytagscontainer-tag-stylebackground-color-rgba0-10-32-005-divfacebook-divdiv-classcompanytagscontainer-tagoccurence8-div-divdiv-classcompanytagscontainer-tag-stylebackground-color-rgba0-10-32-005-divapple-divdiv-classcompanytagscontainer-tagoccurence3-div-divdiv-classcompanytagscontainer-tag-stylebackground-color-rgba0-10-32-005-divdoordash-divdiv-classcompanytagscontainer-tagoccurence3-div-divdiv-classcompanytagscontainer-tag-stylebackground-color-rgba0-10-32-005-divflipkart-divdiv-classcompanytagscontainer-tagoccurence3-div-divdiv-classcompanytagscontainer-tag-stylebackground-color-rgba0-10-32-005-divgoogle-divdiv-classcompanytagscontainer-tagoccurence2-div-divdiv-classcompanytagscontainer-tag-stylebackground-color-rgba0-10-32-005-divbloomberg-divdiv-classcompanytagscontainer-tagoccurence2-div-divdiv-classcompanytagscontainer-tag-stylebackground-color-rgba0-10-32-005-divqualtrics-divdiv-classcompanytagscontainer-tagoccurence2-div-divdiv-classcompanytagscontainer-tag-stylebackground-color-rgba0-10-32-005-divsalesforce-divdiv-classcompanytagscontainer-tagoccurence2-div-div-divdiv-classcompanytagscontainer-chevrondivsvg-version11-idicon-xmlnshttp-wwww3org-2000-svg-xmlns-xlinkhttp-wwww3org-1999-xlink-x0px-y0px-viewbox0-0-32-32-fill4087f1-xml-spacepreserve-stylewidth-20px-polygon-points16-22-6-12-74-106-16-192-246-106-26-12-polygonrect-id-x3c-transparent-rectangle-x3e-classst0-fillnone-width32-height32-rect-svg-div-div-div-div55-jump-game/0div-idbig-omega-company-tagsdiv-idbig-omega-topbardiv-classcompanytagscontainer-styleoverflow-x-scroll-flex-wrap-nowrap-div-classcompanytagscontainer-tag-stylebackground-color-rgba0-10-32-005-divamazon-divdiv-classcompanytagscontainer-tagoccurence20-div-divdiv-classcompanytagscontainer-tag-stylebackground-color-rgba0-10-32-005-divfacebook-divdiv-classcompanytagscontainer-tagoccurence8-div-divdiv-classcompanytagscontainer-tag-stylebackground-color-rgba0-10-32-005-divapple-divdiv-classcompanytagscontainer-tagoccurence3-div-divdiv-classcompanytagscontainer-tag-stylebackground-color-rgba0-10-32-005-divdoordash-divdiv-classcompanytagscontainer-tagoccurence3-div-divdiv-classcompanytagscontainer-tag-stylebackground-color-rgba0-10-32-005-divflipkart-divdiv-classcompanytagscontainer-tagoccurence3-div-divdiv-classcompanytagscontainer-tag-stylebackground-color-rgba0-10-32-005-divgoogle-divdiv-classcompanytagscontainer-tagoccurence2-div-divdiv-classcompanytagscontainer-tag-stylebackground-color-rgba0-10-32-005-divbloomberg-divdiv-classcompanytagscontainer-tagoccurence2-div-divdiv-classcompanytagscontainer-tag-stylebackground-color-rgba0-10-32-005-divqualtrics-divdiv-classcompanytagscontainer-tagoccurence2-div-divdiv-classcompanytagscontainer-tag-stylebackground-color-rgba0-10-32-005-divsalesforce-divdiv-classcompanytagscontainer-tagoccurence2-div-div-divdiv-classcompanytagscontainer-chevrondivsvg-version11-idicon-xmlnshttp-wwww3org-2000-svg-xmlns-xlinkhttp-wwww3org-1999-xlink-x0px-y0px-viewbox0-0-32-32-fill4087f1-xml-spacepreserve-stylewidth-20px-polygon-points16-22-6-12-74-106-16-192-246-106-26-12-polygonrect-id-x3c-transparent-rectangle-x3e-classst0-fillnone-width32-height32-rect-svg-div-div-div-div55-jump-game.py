class Solution:
#     def canReachEnd(self, nums, currentIndex, target, memo):
#         if currentIndex >= target:
#             return True
        
#         if nums[currentIndex] == 0:
#             return False
        
#         ans = False;
        
#         currentKey = currentIndex;
        
#         if currentKey in memo:
#             return memo[currentKey];
        
#         for i in range(1, nums[currentIndex]+1):
#             tempAns = self.canReachEnd(nums, currentIndex+i, target, memo);
#             if tempAns:
#                 return True;
#             ans = ans or tempAns;
#             memo[currentKey] = ans;
            
#         return ans;    
    
    def canJump(self, nums: List[int]) -> bool:
        # return self.canReachEnd(nums, 0, len(nums)-1, dict());
        maxPossibleJump = 0;
        
        for index, jumps in enumerate(nums):
            if index > maxPossibleJump:
                return False;
            possibleJump = index + jumps;
            maxPossibleJump = max(maxPossibleJump, possibleJump);
            if maxPossibleJump >= len(nums) - 1:
                return True;
            
            
        