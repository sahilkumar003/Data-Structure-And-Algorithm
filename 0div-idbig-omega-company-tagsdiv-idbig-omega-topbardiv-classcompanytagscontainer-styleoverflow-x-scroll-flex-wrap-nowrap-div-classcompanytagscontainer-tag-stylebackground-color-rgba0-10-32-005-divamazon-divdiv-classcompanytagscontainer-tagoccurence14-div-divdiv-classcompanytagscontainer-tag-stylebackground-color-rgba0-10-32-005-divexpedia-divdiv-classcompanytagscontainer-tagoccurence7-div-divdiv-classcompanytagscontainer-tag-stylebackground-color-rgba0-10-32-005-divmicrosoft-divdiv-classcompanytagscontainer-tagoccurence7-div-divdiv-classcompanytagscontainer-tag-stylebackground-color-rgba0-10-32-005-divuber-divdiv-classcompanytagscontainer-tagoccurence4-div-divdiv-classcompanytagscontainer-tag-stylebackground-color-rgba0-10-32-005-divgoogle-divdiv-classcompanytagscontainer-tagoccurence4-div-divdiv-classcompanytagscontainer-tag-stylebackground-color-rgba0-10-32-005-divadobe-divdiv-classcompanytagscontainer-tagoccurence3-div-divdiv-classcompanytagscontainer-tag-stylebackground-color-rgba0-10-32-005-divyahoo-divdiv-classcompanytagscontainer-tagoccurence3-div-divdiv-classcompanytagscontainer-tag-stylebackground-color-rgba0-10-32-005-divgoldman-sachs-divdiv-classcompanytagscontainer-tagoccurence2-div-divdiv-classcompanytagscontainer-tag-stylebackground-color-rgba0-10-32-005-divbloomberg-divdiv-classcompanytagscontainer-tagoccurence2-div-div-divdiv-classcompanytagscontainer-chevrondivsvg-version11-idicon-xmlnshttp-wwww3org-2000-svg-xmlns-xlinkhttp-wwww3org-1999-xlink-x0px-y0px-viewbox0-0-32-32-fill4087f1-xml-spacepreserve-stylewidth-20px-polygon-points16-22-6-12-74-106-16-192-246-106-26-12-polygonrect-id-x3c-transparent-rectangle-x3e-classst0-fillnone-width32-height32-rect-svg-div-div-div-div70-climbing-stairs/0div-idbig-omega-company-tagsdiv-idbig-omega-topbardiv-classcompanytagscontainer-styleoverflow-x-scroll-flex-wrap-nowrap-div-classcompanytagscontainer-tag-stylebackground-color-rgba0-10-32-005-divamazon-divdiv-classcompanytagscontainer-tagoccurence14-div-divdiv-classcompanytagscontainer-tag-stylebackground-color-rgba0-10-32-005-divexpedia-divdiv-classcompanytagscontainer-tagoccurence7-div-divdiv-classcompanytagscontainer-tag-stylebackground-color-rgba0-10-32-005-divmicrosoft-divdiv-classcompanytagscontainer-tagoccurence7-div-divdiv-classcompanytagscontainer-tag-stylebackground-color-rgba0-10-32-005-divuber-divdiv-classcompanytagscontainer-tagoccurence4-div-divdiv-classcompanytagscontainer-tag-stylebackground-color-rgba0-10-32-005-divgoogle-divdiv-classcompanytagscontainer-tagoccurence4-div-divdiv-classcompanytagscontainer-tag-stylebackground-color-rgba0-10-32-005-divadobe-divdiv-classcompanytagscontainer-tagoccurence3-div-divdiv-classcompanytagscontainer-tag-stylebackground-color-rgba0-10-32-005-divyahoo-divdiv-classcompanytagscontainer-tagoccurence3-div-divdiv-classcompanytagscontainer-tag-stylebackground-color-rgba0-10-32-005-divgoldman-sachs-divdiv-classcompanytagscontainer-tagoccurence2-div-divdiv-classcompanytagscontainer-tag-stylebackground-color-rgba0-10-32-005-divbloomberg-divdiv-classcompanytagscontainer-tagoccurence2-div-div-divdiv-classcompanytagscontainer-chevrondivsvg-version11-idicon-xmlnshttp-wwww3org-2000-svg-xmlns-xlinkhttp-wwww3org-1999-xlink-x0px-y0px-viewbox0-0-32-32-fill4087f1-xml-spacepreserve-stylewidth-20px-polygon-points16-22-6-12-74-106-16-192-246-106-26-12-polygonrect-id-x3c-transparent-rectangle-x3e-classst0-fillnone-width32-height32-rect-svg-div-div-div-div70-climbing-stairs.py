class Solution:
    def climbStairs(self, n: int) -> int:
        return self.total_ways(0, n, dict());
    
    def total_ways(self, current_stair, target_stair, memo):
        if(current_stair == target_stair):
            return 1;
        
        if (current_stair > target_stair):
            return 0;
        
        if current_stair in memo:
            return memo.get(current_stair)
        
        one_jump = self.total_ways(current_stair + 1, target_stair, memo);
        two_jumps = self.total_ways(current_stair + 2, target_stair, memo);
        
        memo[current_stair] = one_jump + two_jumps;
        
        return one_jump + two_jumps;
        