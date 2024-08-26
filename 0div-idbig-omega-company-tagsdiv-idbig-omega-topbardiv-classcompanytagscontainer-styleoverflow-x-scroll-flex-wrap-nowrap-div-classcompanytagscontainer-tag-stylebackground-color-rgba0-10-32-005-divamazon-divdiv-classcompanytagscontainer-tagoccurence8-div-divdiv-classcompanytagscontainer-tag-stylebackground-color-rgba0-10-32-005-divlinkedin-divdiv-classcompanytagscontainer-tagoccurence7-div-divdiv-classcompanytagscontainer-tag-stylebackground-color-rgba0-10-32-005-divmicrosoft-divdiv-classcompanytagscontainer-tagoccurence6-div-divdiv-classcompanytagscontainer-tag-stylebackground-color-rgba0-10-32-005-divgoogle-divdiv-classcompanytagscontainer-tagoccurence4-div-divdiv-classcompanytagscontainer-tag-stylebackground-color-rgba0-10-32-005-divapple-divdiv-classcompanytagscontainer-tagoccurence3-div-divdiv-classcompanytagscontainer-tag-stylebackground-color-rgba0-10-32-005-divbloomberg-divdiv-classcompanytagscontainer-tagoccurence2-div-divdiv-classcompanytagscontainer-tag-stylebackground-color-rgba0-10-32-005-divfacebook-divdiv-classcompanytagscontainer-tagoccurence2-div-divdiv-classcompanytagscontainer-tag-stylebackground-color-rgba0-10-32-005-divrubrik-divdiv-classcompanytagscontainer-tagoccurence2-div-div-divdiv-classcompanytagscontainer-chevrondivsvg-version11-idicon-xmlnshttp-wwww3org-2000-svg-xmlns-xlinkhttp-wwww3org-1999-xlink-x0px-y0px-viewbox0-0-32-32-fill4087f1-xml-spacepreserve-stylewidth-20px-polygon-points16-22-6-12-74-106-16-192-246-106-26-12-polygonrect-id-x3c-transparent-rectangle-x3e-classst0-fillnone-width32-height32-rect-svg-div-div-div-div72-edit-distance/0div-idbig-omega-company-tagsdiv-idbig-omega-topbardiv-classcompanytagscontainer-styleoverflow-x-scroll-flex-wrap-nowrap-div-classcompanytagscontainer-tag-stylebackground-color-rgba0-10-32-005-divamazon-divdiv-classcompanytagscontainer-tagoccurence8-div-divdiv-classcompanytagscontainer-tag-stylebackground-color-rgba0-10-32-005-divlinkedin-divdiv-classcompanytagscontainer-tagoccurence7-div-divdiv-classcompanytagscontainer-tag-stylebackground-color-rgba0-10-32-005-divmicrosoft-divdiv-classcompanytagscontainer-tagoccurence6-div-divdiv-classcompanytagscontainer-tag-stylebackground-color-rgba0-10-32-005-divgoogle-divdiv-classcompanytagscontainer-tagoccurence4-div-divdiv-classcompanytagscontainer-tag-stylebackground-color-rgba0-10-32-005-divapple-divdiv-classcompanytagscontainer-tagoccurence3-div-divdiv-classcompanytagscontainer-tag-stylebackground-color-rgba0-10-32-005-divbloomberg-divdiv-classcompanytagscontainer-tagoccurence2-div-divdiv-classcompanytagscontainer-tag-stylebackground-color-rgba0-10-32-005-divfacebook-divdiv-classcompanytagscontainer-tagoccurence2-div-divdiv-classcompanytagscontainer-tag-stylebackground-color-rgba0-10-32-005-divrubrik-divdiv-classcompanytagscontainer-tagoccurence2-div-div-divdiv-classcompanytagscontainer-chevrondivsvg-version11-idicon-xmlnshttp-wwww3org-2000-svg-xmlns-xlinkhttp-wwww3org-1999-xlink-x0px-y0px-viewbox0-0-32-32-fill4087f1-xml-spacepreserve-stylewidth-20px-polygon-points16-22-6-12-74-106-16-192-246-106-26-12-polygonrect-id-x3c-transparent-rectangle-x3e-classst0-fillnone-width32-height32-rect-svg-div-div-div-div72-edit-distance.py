class Solution:
    def minNumberOfOperations(self, i, j, word1, word2, memo):  
        if (i>=len(word1)):
            return len(word2)-j;
        
        if (j>=len(word2)):
            return len(word1)-i;
        
        ans = 0;
        currentKey = str(i) + "-" + str(j);
        
        if currentKey in memo:
            return memo[currentKey];
        
        if word1[i] == word2[j]:
            ans =  self.minNumberOfOperations(i+1, j+1, word1, word2, memo);
        else:
            insert = 1 + self.minNumberOfOperations(i, j+1, word1, word2, memo);
            delete = 1 + self.minNumberOfOperations(i+1, j, word1, word2, memo);
            replace = 1 + self.minNumberOfOperations(i+1, j+1, word1, word2, memo);
            ans = min(insert, replace, delete);
        
        memo[currentKey] = ans;
        return ans;    
    
    def minDistance(self, word1: str, word2: str) -> int:
        if len(word1) == 0 and len(word2) == 0:
            return 0;
        
        if len(word2)==0:
            return len(word1);
        
        if len(word1)==0:
            return len(word2);
        
        return self.minNumberOfOperations(0, 0, word1, word2, dict());