class Solution:
    def bestTimeToBuyStock(self, prices, currentIndex, canBuy, fee, memo):
        if currentIndex == len(prices):
            return 0;
        
        currentStockPrice = prices[currentIndex];
        currentKey = str(currentIndex) + "-" + str(canBuy);
        
        if currentKey in memo:
            return memo[currentKey];
        
        if canBuy == 1:
            idle = self.bestTimeToBuyStock(prices, currentIndex+1, canBuy, fee, memo);
            buy = - currentStockPrice + self.bestTimeToBuyStock(prices, currentIndex+1, 0, fee, memo);
            memo[currentKey] = max(idle, buy);
        else:
            idle = self.bestTimeToBuyStock(prices, currentIndex+1, canBuy, fee, memo);
            sell = - fee + currentStockPrice + self.bestTimeToBuyStock(prices, currentIndex+1, 1, fee, memo);
            memo[currentKey] = max(idle,sell);
        return memo[currentKey];
    
    def maxProfit(self, prices: List[int], fee: int) -> int:
         return self.bestTimeToBuyStock(prices, 0, 1, fee, {});
        