class Solution {
    public int minimumCost(int []cost, int targetStair, int currentStair, HashMap<Integer, Integer> memo){
        if(currentStair == targetStair){
            return 0;
        }
        
        if(currentStair > targetStair){
            return 100000;
        }
        
        int currentStairCost = cost[currentStair];
        
        if(memo.containsKey(currentStair)){
            return memo.get(currentStair);
        }
        
        int oneStep = currentStairCost + minimumCost(cost, targetStair, currentStair + 1, memo);
        int twoSteps = currentStairCost + minimumCost(cost, targetStair, currentStair + 2, memo);
        
        memo.put(currentStair,  Math.min(oneStep, twoSteps));
        return Math.min(oneStep, twoSteps);
        
    }
    
    public int minCostClimbingStairs(int[] cost) {
        HashMap<Integer, Integer> memo = new HashMap<Integer, Integer> ();
        int zerothStair = minimumCost(cost, cost.length, 0, memo);
        int firstStair = minimumCost(cost, cost.length, 1, memo);
        
        return Math.min(zerothStair, firstStair);
    }
}