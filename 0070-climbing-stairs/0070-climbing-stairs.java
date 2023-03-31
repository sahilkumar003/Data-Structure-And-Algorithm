class Solution {
    private int totalWays(int currStair, int target, Map<Integer,Integer> memo){
        if(currStair==target){
            return 1;
        }
        if(currStair>target){
            return 0;
        }
        
        int currStairKey = currStair;
        
        if(memo.containsKey(currStairKey)){
            return memo.get(currStairKey);
        }
        
        int oneSteps = totalWays(currStair+1,target,memo);
        int twoSteps = totalWays(currStair+2,target,memo);
        
        memo.put(currStairKey,oneSteps+twoSteps);
        
        return oneSteps+twoSteps;
    }
    
    public int climbStairs(int n) {
        return totalWays(0,n,new HashMap<Integer,Integer>());
    }
}