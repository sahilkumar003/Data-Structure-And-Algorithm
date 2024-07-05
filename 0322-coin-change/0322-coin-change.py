class Solution:
    def minimumCoins(self, currentIndex, coins, amount, dp):
        if amount == 0:
            return 0;
        
        if currentIndex == len(coins):
            return 10001;
        
        currentAmount = coins[currentIndex];
        pick = 10001;
        
        if dp[currentIndex][amount] != -1:
            return dp[currentIndex][amount];
        
        if currentAmount <= amount:
            pick = 1 + self.minimumCoins(currentIndex, coins, amount-currentAmount, dp);
            
        notPick = self.minimumCoins(currentIndex+1, coins, amount, dp);
        dp[currentIndex][amount] = min(pick, notPick);
        
        return min(pick, notPick);
    
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [[-1 for col in range(amount+1)] for row in range(len(coins))];
        ans = self.minimumCoins(0, coins, amount, dp);
        
        if ans == 10001:
            return -1;
        return ans;
        