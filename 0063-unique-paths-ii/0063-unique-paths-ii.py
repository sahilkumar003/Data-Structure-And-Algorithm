class Solution:
    def totalWays(self, currentRow, currentCol, m, n, obstacleGrid, memo):
        if (currentRow >= m or currentCol >=n or obstacleGrid[currentRow][currentCol] ==1):
            return 0;
        
        if (currentRow == m-1 and currentCol == n-1):
            return 1;
        
        currentKey = str(currentRow) + "-" + str(currentCol);
        
        if (currentKey in memo):
            return memo[currentKey];
        
        right = self.totalWays(currentRow, currentCol+1, m, n,obstacleGrid, memo);
        down = self.totalWays(currentRow+1, currentCol, m, n, obstacleGrid, memo);
        
        memo[currentKey] = right + down;
        return right + down;
    
    
    def uniquePathsWithObstacles(self, obstacleGrid: List[List[int]]) -> int:
        return self.totalWays(0, 0, len(obstacleGrid), len(obstacleGrid[0]), obstacleGrid, dict())
        