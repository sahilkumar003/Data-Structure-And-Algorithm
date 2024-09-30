class Solution:
    def bestTimeToBuyStock(self, prices, currentIndex, canBuy, numberOfTransactionAllowed, memo):
        if numberOfTransactionAllowed == 0 or currentIndex == len(prices):
            return 0;
        
        currentStockPrice = prices[currentIndex];
        currentKey = str(currentIndex) + "-" + str(canBuy) + "-" + str(numberOfTransactionAllowed);
        
        if currentKey in memo:
            return memo[currentKey];
        
        buy = 0;
        sell = 0
        
        if canBuy == 1:
            buy = - currentStockPrice + self.bestTimeToBuyStock(prices, currentIndex+1, 0, numberOfTransactionAllowed, memo);
        else:
            sell = currentStockPrice + self.bestTimeToBuyStock(prices, currentIndex+1, 1, numberOfTransactionAllowed-1, memo);
            
        idle = self.bestTimeToBuyStock(prices, currentIndex+1, canBuy, numberOfTransactionAllowed, memo);
        memo[currentKey] = max(idle, buy, sell);
        
        return memo[currentKey];    
        
    
    def maxProfit(self, prices: List[int]) -> int:
        return self.bestTimeToBuyStock(prices, 0, 1, 1, {});
        