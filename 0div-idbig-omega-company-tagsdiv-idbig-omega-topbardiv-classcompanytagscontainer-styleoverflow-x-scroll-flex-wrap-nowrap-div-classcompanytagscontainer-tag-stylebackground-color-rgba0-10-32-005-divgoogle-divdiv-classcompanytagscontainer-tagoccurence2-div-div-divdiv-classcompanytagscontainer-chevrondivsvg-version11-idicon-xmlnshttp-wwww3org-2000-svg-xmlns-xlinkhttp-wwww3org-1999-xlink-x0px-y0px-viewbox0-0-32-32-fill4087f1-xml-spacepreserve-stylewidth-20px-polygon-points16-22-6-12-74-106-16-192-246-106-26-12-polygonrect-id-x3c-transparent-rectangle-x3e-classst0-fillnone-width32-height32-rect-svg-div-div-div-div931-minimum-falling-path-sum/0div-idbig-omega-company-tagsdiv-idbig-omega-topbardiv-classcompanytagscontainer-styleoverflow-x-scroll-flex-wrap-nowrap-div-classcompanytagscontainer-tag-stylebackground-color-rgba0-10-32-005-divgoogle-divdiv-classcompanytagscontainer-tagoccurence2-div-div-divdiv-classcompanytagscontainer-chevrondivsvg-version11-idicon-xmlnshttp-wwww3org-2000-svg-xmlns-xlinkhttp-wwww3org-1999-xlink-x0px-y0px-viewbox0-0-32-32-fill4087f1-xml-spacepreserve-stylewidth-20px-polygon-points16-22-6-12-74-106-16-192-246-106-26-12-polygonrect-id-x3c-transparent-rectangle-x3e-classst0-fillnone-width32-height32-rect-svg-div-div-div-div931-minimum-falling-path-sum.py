class Solution:
    def findPath(self, currentRow, currentCol, matrix, memo):
        if (currentRow > len(matrix)-1 or currentCol < 0 or currentCol > len(matrix[0])-1):
            return  float('inf');
        
        if (currentRow == len(matrix)-1):
            return matrix[currentRow][currentCol];
        
        currentValue = matrix[currentRow][currentCol];
        currentKey = str(currentRow) + "-" + str(currentCol);
        
        if currentKey in memo:
            return memo[currentKey];
        
        leftDiagonal = currentValue + self.findPath(currentRow+1, currentCol-1, matrix, memo);
        down = currentValue + self.findPath(currentRow+1, currentCol, matrix, memo);
        rightDiagonal = currentValue + self.findPath(currentRow+1, currentCol+1, matrix, memo);
        
        memo[currentKey] = min(leftDiagonal, down, rightDiagonal);
            
        return min(leftDiagonal, down, rightDiagonal);
            
    
    def minFallingPathSum(self, matrix: List[List[int]]) -> int:
        minPath =  float('inf');
        memo = {}
        for i in range(len(matrix)):
            temp = self.findPath(0, i, matrix, memo);
            minPath = min(minPath, temp);
            
        return minPath;
        