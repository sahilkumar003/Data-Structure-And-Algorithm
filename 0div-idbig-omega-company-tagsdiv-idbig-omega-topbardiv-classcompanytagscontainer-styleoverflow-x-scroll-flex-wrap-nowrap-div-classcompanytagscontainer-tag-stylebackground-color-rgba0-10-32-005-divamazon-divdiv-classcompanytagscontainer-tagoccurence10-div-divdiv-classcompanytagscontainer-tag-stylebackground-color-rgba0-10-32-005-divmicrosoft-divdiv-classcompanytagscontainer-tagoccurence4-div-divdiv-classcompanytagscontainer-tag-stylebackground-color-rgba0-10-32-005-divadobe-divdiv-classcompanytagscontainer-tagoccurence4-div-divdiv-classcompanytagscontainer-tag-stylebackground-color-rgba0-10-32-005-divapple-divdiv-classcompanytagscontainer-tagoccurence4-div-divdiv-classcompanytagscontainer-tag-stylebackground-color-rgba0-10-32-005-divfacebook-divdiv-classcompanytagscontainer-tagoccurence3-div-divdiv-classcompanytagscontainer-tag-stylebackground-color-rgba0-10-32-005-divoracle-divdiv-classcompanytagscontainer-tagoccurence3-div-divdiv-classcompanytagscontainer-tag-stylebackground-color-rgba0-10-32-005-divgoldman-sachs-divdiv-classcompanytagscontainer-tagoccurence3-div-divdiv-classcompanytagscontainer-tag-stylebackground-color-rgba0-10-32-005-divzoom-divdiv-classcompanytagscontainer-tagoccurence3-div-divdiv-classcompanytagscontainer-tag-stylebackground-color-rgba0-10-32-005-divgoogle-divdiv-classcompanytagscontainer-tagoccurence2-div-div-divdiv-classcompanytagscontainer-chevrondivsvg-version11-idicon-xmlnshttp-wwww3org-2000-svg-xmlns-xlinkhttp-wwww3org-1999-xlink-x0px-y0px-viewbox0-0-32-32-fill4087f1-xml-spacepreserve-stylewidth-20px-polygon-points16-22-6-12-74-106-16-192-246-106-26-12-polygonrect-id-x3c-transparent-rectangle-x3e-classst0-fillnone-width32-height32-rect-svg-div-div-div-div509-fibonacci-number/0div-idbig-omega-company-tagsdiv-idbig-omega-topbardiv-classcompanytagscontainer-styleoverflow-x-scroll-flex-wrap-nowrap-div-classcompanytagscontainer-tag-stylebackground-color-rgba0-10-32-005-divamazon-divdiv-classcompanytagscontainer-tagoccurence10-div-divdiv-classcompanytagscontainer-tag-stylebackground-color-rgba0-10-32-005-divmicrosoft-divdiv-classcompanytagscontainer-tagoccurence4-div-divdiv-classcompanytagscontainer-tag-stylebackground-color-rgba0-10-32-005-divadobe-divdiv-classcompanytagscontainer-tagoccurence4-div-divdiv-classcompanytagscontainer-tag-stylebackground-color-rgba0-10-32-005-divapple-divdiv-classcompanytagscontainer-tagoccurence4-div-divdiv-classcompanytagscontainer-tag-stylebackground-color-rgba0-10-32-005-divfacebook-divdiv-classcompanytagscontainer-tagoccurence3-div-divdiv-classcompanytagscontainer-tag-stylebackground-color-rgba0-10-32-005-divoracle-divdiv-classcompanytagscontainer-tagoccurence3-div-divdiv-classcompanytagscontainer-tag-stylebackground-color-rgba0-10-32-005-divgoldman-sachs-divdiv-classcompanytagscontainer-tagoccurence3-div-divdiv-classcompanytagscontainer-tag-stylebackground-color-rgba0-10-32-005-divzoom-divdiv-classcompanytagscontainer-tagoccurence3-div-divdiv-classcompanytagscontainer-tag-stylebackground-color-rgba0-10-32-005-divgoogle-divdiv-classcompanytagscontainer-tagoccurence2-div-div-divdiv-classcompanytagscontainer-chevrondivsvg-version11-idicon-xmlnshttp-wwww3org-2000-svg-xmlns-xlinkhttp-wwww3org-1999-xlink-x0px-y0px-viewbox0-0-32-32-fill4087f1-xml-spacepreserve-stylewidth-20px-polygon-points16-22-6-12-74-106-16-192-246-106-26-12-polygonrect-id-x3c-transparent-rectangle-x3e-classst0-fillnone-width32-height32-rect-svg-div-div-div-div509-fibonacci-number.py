class Solution:
    def fib(self, n: int) -> int:
       return self.nth_fibo(n);
    
    def nth_fibo(self, n):
        if n == 0:
            return 0;
        
        if n == 1:
            return 1;
    
        a: int = self.nth_fibo(n-1);
        b: int = self.nth_fibo(n-2);
        return a + b;