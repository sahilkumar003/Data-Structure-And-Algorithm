class Solution:
    def totalWays(self, currentRow, currentCol, m, n, memo):
        if (currentRow == m-1 and currentCol == n-1):
            return 1;
        
        if (currentRow >= m or currentCol >=n):
            return 0;
        
        currentKey = str(currentRow) + "-" + str(currentCol);
        
        if (currentKey in memo):
            return memo[currentKey];
        
        right = self.totalWays(currentRow, currentCol+1, m, n, memo);
        down = self.totalWays(currentRow+1, currentCol, m, n, memo);
        
        memo[currentKey] = right + down;
        return right + down;
    
    
    def uniquePaths(self, m: int, n: int) -> int:
        return self.totalWays(0, 0, m, n, dict());
        