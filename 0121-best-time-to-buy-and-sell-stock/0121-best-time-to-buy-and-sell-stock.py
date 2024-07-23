class Solution:
    def bestTimeToBuyStock(self, prices, currentIndex, canBuy, numberOfTransactionAllowed, memo):
        if numberOfTransactionAllowed == 0 or currentIndex == len(prices):
            return 0;
        
        currentStockPrice = prices[currentIndex];
        buy = -10000;
        sell = -10000;
        
        currentKey = str(currentIndex) + "-" + str(canBuy) + "-" + str(numberOfTransactionAllowed);
        
        if currentKey in memo:
            return memo[currentKey];
        
        idle = self.bestTimeToBuyStock(prices, currentIndex+1, canBuy, numberOfTransactionAllowed, memo);
        if canBuy == 1:  
            buy = - currentStockPrice + self.bestTimeToBuyStock(prices, currentIndex+1, 0, numberOfTransactionAllowed, memo);
        else:
            sell = currentStockPrice + self.bestTimeToBuyStock(prices, currentIndex+1, 1, numberOfTransactionAllowed-1, memo);
        
        memo[currentKey] = max(idle, buy) if buy != -10000 else max(idle, sell);
        return memo[currentKey];
        
    
    def maxProfit(self, prices: List[int]) -> int:
        return self.bestTimeToBuyStock(prices, 0, 1, 1, {});
        