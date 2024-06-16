class Solution:
    def fib(self, n: int) -> int:
       return self.nth_fibo(n, {});
    
    def nth_fibo(self, n, memo):
        if n == 0:
            return 0;
        
        if n == 1:
            return 1;
        
        currentKey: int = n;
        
        if(currentKey in memo):
            return memo[currentKey];
    
        a: int = self.nth_fibo(n-1, memo);
        b: int = self.nth_fibo(n-2, memo);
            
        memo [currentKey] = a + b;    
        return a + b;