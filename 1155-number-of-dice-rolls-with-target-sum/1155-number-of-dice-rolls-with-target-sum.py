MOD = 1000000007;
class Solution:
    def totalWays(self, currentDice, totalDice, faces, target, memo):
        if currentDice == totalDice and target == 0:
            return 1;
        
        if currentDice > totalDice or target < 0:
            return 0;
        
        currentKey = str(currentDice) + "-" + str(target);
        
        if currentKey in memo:
            return memo[currentKey];
        
        totalWays = 0;
        
        for face in range(1, faces+1):
            totalWays += self.totalWays(currentDice+1, totalDice, faces, target-face, memo) % MOD;
        
        memo[currentKey] = totalWays % MOD;   
        return totalWays % MOD;    
    
    def numRollsToTarget(self, n: int, k: int, target: int) -> int:
        return self.totalWays(0, n, k, target, dict()) % MOD;
        