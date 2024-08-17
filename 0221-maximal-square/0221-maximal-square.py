class Solution:
    def findSquare(self, currentRow, currentCol, matrix, memo):
        if (currentRow >= len(matrix) or currentCol >= len(matrix[0]) or matrix[currentRow][currentCol] == "0"):
            return 0;
        
        currentKey = str(currentRow) + "-" + str(currentCol);
        
        if currentKey in memo:
            return memo[currentKey];
        
        right = 1 + self.findSquare(currentRow, currentCol+1, matrix, memo);
        down = 1 + self.findSquare(currentRow+1, currentCol, matrix, memo);
        rightDiagonal = 1 + self.findSquare(currentRow+1, currentCol+1, matrix, memo);
        
        memo[currentKey] = min(right, down, rightDiagonal);
        return min(right, down, rightDiagonal);
    
    def maximalSquare(self, matrix: List[List[str]]) -> int:
        maxSquare = 0;
        memo = {}
        
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == "1":
                    temp = self.findSquare(row, col, matrix, memo);
                    maxSquare = max(maxSquare, temp);
                 
        return maxSquare*maxSquare;        
        