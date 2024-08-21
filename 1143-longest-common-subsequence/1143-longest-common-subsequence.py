class Solution:
    def findLCS(self, index1, index2, str1, str2, memo):
        if index1 >= len(str1) or index2 >= len(str2):
            return 0;
        
        moveBothIndex = 0;
        moveOneIndex = 0;
        currentKey = str(index1) + "-" + str(index2);
        
        if currentKey in memo:
            return memo[currentKey];
        
        if str1[index1] == str2[index2]:
            moveBothIndex = 1 + self.findLCS(index1+1, index2+1, str1, str2, memo)
        else:
            moveFirstIndex = self.findLCS(index1+1, index2, str1, str2, memo)
            moveSecondIndex = self.findLCS(index1, index2+1, str1, str2, memo)
            moveOneIndex= max(moveFirstIndex, moveSecondIndex)
        
        memo[currentKey] = max(moveBothIndex, moveOneIndex)
        return max(moveBothIndex, moveOneIndex);    
            
    
    def longestCommonSubsequence(self, text1: str, text2: str) -> int:
        return self.findLCS(0, 0, text1, text2, dict());
        