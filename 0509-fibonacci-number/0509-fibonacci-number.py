class Solution:
    def calculateFibonaacci(self, n :int) -> int:
        if(n==0):
            return 0
        elif(n==1 or n==2):
            return 1
        
        return self.calculateFibonaacci(n-1) + self.calculateFibonaacci(n-2)
    
    def fib(self, n: int) -> int:
        if(n==0):
            return 0
        elif(n==1 or n==2):
            return 1
        return self.calculateFibonaacci(n-1) + self.calculateFibonaacci(n-2)
        