class Solution {
    public int totalWays(int n, int currentStair, HashMap<Integer, Integer> memo){
        if (currentStair == n){
            return 1;
        }
        
        if (currentStair > n){
            return 0;
        }
        
        if (memo.containsKey(currentStair)){
            return memo.get(currentStair);
        }
        
        int oneStep = totalWays(n, currentStair+1, memo);
        int twoSteps = totalWays(n, currentStair+2, memo);
        
        memo.put(currentStair, oneStep+twoSteps);
        return oneStep + twoSteps;
    }
    
    public int climbStairs(int n) {
        return totalWays(n, 0, new HashMap<Integer, Integer> ());
    }
}