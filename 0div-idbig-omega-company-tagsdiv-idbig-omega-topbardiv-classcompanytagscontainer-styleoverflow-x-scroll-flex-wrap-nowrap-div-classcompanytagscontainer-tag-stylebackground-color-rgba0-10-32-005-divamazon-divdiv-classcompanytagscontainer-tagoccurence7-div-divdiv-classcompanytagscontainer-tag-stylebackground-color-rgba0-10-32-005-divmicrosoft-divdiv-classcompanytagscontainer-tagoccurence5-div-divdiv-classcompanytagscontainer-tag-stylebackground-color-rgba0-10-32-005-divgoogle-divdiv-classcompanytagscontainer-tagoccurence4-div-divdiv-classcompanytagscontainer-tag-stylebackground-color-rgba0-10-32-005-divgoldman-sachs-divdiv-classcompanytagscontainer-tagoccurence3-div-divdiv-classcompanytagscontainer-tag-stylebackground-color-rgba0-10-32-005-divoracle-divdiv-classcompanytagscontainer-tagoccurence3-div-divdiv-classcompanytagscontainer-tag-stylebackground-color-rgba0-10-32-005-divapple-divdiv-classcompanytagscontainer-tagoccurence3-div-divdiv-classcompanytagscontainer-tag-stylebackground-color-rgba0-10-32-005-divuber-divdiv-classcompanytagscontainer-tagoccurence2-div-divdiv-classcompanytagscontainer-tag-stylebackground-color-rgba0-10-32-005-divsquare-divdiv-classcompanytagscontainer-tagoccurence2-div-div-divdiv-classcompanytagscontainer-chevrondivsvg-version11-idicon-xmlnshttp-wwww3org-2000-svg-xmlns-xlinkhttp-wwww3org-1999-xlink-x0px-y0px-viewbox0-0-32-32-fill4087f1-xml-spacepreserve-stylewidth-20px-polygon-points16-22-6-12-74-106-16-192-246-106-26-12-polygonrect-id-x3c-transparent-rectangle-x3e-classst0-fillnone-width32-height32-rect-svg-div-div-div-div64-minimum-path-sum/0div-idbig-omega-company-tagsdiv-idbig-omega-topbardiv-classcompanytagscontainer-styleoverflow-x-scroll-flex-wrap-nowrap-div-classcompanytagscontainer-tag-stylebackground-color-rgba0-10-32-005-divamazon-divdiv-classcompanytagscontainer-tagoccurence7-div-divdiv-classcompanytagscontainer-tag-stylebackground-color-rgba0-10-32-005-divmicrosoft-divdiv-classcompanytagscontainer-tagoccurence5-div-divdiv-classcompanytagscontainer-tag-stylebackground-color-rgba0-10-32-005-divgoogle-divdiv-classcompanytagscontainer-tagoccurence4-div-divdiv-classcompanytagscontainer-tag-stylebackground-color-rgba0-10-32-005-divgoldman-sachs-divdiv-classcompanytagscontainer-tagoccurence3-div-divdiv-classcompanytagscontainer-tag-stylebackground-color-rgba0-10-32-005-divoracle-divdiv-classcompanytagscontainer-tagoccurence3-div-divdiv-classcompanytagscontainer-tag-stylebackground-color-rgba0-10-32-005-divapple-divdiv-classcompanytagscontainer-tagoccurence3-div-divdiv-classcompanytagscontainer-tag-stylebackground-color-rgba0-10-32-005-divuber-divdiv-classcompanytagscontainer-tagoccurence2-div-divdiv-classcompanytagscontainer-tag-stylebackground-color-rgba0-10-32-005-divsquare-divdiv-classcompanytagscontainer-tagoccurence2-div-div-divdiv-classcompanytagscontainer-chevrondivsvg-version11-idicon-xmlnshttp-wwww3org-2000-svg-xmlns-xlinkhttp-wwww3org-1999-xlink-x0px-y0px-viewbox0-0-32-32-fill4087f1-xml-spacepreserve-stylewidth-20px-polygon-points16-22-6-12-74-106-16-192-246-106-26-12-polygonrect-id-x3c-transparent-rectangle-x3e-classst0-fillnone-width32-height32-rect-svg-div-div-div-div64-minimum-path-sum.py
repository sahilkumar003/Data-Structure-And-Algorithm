class Solution:
    def findPath(self, currentRow, currentCol, totalRows, totalCols, grid, memo):
        if (currentRow>=totalRows or currentCol>=totalCols):
            return 40000;
            
        if (currentRow == totalRows-1 and currentCol == totalCols-1):
            return grid[currentRow][currentCol];
        
        currentValue = grid[currentRow][currentCol];
        currentKey = str(currentRow) + "-" + str(currentCol);
        
        if currentKey in memo:
            return memo[currentKey];
        
        right = currentValue + self.findPath(currentRow, currentCol+1, totalRows, totalCols, grid, memo);
        down = currentValue + self.findPath(currentRow+1, currentCol, totalRows, totalCols, grid, memo);
        memo[currentKey] = min(right, down);
        
        return min(right, down);
    
    def minPathSum(self, grid: List[List[int]]) -> int:
        return self.findPath(0, 0, len(grid), len(grid[0]), grid, dict());
        