class Solution {
    public int rob(int[] arr) {
        return maxCost(0,arr,new HashMap<Integer,Integer>());
    }
    
    private int maxCost(int currHouse, int []arr, Map<Integer,Integer> cache){
        if(currHouse>=arr.length){
            return 0;
        }
        
        int currKey = currHouse;
        
        if(cache.containsKey(currKey)){
            return cache.get(currKey);
        }
        
        int rob = arr[currHouse] + maxCost(currHouse+2,arr,cache);
        int notRob = maxCost(currHouse+1,arr,cache);
        
        cache.put(currKey,Math.max(rob,notRob));
        
        return cache.get(currKey);
    }
}