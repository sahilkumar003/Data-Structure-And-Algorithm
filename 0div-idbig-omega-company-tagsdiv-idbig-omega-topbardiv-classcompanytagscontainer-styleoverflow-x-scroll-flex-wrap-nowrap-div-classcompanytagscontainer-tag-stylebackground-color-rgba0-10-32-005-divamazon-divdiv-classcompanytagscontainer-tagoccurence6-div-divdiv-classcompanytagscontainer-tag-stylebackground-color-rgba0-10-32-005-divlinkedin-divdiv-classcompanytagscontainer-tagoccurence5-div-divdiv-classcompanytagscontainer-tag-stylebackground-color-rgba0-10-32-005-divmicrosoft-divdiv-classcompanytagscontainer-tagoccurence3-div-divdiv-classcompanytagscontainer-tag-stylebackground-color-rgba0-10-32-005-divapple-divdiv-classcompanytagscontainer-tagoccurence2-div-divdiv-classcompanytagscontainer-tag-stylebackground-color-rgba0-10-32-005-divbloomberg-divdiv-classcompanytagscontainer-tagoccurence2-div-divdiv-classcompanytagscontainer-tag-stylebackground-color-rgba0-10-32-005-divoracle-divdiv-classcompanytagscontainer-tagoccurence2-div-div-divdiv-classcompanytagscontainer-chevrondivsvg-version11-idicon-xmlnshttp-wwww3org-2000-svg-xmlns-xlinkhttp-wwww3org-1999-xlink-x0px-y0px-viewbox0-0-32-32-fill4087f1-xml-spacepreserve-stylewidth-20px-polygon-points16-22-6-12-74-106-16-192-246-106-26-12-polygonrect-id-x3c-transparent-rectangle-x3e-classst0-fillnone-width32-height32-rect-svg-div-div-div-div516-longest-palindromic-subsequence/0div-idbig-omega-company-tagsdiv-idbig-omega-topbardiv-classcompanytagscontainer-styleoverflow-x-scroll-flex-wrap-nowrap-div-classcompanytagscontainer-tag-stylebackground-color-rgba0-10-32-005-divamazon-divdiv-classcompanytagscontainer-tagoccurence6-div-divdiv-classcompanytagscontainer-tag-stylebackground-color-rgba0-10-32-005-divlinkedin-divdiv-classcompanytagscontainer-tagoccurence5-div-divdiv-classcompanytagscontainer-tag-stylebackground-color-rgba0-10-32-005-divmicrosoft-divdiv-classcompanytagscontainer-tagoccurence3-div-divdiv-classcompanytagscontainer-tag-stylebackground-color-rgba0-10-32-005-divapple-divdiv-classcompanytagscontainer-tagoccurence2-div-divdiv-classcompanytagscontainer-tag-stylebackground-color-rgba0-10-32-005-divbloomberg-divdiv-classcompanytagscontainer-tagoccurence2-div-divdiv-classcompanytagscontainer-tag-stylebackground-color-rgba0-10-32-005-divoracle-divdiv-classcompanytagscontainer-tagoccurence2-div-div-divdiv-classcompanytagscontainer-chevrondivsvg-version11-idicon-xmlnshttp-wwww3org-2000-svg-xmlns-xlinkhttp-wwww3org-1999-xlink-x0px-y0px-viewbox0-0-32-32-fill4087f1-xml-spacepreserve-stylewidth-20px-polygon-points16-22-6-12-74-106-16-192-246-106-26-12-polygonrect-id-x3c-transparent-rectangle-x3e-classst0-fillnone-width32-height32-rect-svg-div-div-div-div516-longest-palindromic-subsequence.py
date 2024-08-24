class Solution:
    def findLCS(self, index1, index2, str1, str2, memo):
        if index1 >= len(str1) or index2 >= len(str2):
            return 0;
        
        ans = 0;
        currentKey = str(index1) + "-" + str(index2);
        
        if currentKey in memo:
            return memo[currentKey];
        
        if str1[index1] == str2[index2]:
            ans = 1 + self.findLCS(index1+1, index2+1, str1, str2, memo)
        else:
            moveFirstIndex = self.findLCS(index1+1, index2, str1, str2, memo)
            moveSecondIndex = self.findLCS(index1, index2+1, str1, str2, memo)
            ans= max(moveFirstIndex, moveSecondIndex)
        
        memo[currentKey] = ans
        return ans;   
    
    def longestPalindromeSubseq(self, s: str) -> int:
        text2 = s[::-1]
        return self.findLCS(0, 0, s, text2, dict());