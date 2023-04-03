class Solution {
    private int ans(int n,Map<Integer,Integer> cache){
        if(n<2){
            return n;
        }
        if(n==2){
            return 1;
        }
        
        int currKey = n;
        
        if(cache.containsKey(currKey)){
            return cache.get(currKey);
        }
        
        int first = ans(n-1,cache);
        int second = ans(n-2,cache);
        int third = ans(n-3,cache);
        
        cache.put(currKey,first+second+third);
        
        return cache.get(currKey);
    }
    
    public int tribonacci(int n) {
     return ans(n,new HashMap<Integer,Integer>());   
    }
}