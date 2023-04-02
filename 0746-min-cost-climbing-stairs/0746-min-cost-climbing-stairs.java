class Solution {
    private int minCost(int currStair, int[]cost, Map<Integer,Integer> cache){
        if(currStair == cost.length){
            return 0;
        }
        
        if(currStair > cost.length){
            return 100000;
        }
        
        int currKey = currStair;
        
        if(cache.containsKey(currKey)){
            return cache.get(currKey);
        }
        
        int oneStep = cost[currStair] + minCost(currStair+1, cost, cache);
        int twoStep = cost[currStair] + minCost(currStair+2, cost, cache);
        
        cache.put(currKey,Math.min(oneStep,twoStep));
        
        return cache.get(currKey);
    }
    
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer,Integer> cache = new HashMap<>();
        return Math.min(minCost(0,cost,cache),cache.get(1));
    }
}