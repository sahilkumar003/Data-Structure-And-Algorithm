class Solution:
    def calculateClimbingStairsCost(self, cost: List[int], currentStairs: int, targetStairs: int, memo: dict[int, int]):
        if currentStairs == targetStairs:
            return 0;
        
        if currentStairs > targetStairs:
            return 1000;
        
        currentKey: int = currentStairs;
            
        if (currentKey in memo):
            return memo[currentKey]
        
        oneStep = cost[currentStairs] + self.calculateClimbingStairsCost(cost, currentStairs + 1, targetStairs, memo)
        twoSteps = cost[currentStairs]  + self.calculateClimbingStairsCost(cost, currentStairs + 2, targetStairs, memo)
        
        memo[currentStairs] = min(oneStep, twoSteps);
        
        return min(oneStep, twoSteps);
    
    def minCostClimbingStairs(self, cost: List[int]) -> int:
        startingPointZero = self.calculateClimbingStairsCost(cost, 0, len(cost), {});
        startingPointOne = self.calculateClimbingStairsCost(cost, 1, len(cost), {});
        
        return min(startingPointZero, startingPointOne);
        