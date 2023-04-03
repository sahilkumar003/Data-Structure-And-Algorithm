class Solution {
    private int ans(int n,Map<Integer,Integer> cache){
        if(n<2){
            return n;
        }
        
        int currKey = n;
        
        if(cache.containsKey(currKey)){
            return cache.get(currKey);
        }
        
        int firstHalf = ans(n-1,cache);
        int secondHalf = ans(n-2,cache);
        
        cache.put(currKey,firstHalf+secondHalf);
        
        return cache.get(currKey);
    }
    
    public int fib(int n) {
       return ans(n,new HashMap<Integer,Integer>());
    }
}