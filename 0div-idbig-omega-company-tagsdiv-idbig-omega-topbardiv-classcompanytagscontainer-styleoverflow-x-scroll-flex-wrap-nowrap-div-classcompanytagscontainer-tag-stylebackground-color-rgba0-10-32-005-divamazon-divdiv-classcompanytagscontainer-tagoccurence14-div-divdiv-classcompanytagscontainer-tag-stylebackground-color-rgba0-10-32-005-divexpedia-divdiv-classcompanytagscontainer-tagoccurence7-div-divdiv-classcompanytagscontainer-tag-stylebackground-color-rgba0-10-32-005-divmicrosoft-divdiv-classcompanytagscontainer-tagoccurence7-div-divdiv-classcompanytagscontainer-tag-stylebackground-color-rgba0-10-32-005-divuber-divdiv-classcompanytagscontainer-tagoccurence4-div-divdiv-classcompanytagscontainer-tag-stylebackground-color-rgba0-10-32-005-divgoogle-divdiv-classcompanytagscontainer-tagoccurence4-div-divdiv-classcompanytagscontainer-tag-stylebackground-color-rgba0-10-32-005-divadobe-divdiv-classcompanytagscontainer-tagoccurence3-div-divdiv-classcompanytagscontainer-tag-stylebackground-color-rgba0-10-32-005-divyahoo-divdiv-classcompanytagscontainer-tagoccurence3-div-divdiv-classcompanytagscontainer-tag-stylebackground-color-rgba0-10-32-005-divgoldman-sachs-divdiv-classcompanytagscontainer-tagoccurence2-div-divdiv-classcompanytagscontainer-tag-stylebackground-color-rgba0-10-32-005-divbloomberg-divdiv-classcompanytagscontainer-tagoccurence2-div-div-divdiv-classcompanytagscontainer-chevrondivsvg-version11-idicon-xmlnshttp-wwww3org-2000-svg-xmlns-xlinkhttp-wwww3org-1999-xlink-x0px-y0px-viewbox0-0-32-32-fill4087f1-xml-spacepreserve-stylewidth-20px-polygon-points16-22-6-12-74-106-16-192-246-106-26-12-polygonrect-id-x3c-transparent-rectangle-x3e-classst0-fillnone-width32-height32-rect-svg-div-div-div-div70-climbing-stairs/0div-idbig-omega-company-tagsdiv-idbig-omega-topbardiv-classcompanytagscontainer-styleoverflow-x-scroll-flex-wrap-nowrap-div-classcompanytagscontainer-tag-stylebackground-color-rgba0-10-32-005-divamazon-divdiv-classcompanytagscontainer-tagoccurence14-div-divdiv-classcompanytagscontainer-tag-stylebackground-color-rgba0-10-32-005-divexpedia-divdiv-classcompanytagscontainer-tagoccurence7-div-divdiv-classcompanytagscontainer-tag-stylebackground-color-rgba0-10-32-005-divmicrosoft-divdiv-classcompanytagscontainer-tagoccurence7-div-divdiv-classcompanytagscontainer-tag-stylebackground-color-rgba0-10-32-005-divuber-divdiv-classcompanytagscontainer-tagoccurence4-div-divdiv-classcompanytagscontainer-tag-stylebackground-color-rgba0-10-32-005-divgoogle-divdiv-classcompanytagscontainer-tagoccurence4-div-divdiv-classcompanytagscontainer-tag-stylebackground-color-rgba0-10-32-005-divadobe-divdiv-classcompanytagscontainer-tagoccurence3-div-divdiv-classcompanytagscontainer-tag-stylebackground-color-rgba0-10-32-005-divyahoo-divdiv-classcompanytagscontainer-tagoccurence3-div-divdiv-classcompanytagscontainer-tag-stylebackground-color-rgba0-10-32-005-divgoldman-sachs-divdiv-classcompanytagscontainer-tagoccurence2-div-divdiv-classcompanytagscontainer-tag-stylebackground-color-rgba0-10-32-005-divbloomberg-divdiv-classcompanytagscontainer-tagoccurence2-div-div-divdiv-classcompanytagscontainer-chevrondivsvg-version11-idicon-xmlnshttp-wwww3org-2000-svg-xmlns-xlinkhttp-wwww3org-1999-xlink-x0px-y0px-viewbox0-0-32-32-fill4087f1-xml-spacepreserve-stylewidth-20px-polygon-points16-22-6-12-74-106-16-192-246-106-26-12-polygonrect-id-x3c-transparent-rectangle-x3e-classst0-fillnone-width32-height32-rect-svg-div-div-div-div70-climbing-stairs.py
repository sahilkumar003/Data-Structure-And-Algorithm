class Solution:
    def climbStairs(self, n: int) -> int:
        return self.total_ways(0, n, dict());
    
    def total_ways(self, current_stair, target_stair, memo):
        if(current_stair == target_stair):
            return 1;
        
        if (current_stair > target_stair):
            return 0;
        
        current_key = current_stair;
        
        if current_key in memo:
            return memo.get(current_key)
        
        one_jump = self.total_ways(current_stair + 1, target_stair, memo);
        two_jumps = self.total_ways(current_stair + 2, target_stair, memo);
        
        memo[current_key] = one_jump + two_jumps;
        
        return one_jump + two_jumps;
        