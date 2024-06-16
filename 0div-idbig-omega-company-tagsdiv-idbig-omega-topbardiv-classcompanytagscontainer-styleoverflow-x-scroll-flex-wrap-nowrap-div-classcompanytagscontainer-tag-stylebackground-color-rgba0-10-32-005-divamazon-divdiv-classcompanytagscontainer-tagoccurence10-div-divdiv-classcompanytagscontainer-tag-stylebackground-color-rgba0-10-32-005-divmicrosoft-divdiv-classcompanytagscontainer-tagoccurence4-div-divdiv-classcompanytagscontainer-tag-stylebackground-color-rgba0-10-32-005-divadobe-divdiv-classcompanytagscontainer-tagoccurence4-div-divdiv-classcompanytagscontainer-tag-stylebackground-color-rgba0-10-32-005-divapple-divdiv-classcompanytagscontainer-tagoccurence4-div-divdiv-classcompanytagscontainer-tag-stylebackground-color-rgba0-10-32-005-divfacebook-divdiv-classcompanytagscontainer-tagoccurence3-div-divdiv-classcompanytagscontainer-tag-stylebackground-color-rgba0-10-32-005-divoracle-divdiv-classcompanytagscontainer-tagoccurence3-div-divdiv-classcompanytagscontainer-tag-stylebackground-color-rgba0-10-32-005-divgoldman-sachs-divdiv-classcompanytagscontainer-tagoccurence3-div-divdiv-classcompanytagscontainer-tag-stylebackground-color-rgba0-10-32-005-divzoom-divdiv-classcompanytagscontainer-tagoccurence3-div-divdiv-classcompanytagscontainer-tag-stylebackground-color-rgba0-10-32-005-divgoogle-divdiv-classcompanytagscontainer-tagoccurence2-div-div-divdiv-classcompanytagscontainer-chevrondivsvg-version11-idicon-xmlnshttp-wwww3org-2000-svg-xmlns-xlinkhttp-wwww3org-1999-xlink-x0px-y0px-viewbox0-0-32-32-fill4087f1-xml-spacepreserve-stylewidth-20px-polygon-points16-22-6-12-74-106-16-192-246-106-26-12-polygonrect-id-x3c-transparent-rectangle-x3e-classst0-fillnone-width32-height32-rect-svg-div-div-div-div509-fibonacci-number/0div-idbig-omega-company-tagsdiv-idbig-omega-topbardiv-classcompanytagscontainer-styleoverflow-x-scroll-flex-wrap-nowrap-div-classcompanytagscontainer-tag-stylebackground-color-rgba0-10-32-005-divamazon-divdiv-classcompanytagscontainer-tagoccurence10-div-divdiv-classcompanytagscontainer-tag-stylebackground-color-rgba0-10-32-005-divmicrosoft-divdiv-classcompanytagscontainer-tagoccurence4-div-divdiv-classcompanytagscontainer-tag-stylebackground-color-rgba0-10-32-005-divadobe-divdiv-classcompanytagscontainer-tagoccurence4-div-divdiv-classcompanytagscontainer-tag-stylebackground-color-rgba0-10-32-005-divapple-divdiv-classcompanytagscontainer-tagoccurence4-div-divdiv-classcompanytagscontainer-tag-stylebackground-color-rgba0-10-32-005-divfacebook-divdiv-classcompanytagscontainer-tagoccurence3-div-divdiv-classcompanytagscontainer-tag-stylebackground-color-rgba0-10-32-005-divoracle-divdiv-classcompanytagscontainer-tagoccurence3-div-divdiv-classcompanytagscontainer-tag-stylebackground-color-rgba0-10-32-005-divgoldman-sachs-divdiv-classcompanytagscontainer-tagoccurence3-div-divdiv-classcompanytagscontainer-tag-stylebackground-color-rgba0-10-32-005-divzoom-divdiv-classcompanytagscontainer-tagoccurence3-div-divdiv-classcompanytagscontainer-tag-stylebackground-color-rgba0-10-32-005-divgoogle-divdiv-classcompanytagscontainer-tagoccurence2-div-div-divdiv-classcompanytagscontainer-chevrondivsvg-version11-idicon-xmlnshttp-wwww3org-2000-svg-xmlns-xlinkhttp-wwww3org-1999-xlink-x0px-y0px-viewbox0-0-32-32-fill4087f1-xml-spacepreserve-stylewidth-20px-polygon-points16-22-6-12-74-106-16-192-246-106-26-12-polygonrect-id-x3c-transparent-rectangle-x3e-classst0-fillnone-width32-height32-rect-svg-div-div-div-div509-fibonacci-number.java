class Solution {
    private int nthFibo(int n , HashMap<Integer, Integer> memo){
        if (n == 0)
            return 0;
        
        if (n == 1)
            return 1;
        
        int currentKey = n;
        
        if (memo.containsKey(currentKey)){
            return memo.get(currentKey);
        }
        
        int a = nthFibo(n-1, memo);
        int b = nthFibo(n-2, memo);
        
        memo.put(currentKey, a+b);
        
        return a + b;
    }
    
    public int fib(int n) {
       return nthFibo(n, new HashMap<Integer, Integer>());
    }
}