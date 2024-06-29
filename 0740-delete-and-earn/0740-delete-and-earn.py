class Solution:
    def maximumPoints(self, currentIndex, frequencyDict, memo):
        if currentIndex not in frequencyDict:
            return 0;
        currentPoint = currentIndex * frequencyDict[currentIndex];
        currentKey = currentIndex;
        
        if currentKey in memo:
            return memo[currentKey];
        
        pick = currentPoint + self.maximumPoints(currentIndex+2, frequencyDict, memo);
        notPick = self.maximumPoints(currentIndex+1, frequencyDict, memo);
        
        memo[currentKey] = max(pick, notPick);
        return max(pick, notPick);
       
    
    def deleteAndEarn(self, nums: List[int]) -> int:
        frequencyDict = {}
        maxPoint = 0;
        for element in nums:
            maxPoint = max(maxPoint, element);
        
        for index in range(maxPoint+1):
            frequencyDict[index] = 0;
            
        for element in nums:
            if element in frequencyDict:
                frequencyDict[element] = frequencyDict[element] + 1;
                
        memo = {}        
        
        return self.maximumPoints(0, frequencyDict, memo);
        