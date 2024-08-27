class Solution:
    def minimumSum(self,i, j, triangle, memo):
        if (i == len(triangle)-1):
            return triangle[i][j];
        
        currentValue = triangle[i][j];
        currentKey = str(i) + "-" + str(j);
        
        if currentKey in memo:
            return memo[currentKey];
        
        leftDiagonal = currentValue + self.minimumSum(i+1, j, triangle, memo);
        rightDiagonal = currentValue + self.minimumSum(i+1, j+1, triangle, memo);
        
        memo[currentKey] = min(leftDiagonal, rightDiagonal);
        return min(leftDiagonal, rightDiagonal);
    
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        return self.minimumSum(0, 0, triangle, dict());