class Solution:
    def totalWays(self, currentIndex, amount, coins, dp):
        if amount == 0:
            return 1;
        
        if currentIndex >= len(coins):
            return 0;
        
        currentAmount = coins[currentIndex];
        pick = 0;
        
        if dp[currentIndex][amount] != -1:
            return dp[currentIndex][amount];
        
        if currentAmount <= amount:
            pick = self.totalWays(currentIndex, amount-currentAmount, coins, dp);
        
        notPick = self.totalWays(currentIndex+1, amount, coins, dp);
        dp[currentIndex][amount] = pick + notPick;
        return pick + notPick;
    
    def change(self, amount: int, coins: List[int]) -> int:
        dp = [[-1 for col in range(amount+1)] for row in range(len(coins))]
        return self.totalWays(0, amount, coins, dp);
        