class Solution:
    def uniqueBST(self, n, memo):
        if (n==0 or n==1):
            return 1;
            
        ways = 0;
        currentKey = n;
        
        if memo[currentKey] != -1:
            return memo[currentKey];
            
        for i in range(0,n):
            ways += self.uniqueBST(i, memo) * self.uniqueBST(n-i-1, memo);
            
        memo[currentKey] = ways;
        return ways;
    
    def numTrees(self, n: int) -> int:
        dp = [-1 for i in range(n+1)]
        return self.uniqueBST(n, dp);
        