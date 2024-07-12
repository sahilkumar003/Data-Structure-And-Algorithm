class Solution:
    def canFrogCross(self, stones, currentIndex, k, target, stonesDict):
        if currentIndex == target:
            return True;
        
        if k == 0 or currentIndex not in stones:
            return False;
        
        currentKey = str(currentIndex) + "-" + str(k);
        
        if currentKey in stonesDict:
            return stonesDict[currentKey];
        
        previousStone = self.canFrogCross(stones, currentIndex+(k-1), k-1, target, stonesDict);
        if previousStone: return True;
        
        sameStone = self.canFrogCross(stones, currentIndex+k, k, target, stonesDict);
        if sameStone: return True;
        
        nextStone = self.canFrogCross(stones, currentIndex+(k+1), k+1, target, stonesDict);
        if nextStone: return True;
        
        stonesDict[currentKey] = previousStone or sameStone or nextStone;
        
        return previousStone or sameStone or nextStone;
    
    def canCross(self, stones: List[int]) -> bool:
        target = stones[len(stones)-1];
        stonesDict = {}
        startingStone = stones[0];
        
        return self.canFrogCross(stones, startingStone+1 , 1, target, stonesDict);
        
        