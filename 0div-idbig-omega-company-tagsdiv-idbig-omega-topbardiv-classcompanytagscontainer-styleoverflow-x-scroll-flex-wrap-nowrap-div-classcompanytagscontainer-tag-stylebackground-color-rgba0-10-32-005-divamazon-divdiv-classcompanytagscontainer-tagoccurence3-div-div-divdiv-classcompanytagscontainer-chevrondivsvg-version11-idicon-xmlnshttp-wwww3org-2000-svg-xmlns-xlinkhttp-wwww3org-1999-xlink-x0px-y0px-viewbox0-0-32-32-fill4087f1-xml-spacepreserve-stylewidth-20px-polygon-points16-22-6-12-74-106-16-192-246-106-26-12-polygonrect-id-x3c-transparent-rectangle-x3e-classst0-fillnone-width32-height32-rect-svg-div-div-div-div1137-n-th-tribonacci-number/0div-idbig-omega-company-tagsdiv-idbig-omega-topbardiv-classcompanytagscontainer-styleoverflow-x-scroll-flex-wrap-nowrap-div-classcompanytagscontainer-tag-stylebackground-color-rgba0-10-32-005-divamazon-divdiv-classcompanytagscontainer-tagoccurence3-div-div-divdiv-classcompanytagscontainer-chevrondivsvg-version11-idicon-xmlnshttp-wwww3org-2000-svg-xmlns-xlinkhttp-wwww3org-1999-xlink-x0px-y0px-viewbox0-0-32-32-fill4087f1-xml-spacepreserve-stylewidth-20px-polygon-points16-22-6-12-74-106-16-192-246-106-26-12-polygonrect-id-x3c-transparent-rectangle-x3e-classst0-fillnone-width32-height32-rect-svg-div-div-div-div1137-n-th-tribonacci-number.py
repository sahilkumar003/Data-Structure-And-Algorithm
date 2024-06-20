class Solution:
    def calculateTribonacci(self, n: int, memo: dict)-> int:
        if (n<=0):
            return 0;
        if(n==1 or n==2):
            return 1;
        
        currentKey = n;
        
        if currentKey in memo:
            return memo[currentKey];
        
        
        total = self.calculateTribonacci(n-1, memo) + self.calculateTribonacci(n-2, memo) + self.calculateTribonacci(n-3, memo);
        
        memo[currentKey] = total;
        
        return total;
    
    def tribonacci(self, n: int) -> int:
        memo = {}
        return self.calculateTribonacci(n, memo);
        