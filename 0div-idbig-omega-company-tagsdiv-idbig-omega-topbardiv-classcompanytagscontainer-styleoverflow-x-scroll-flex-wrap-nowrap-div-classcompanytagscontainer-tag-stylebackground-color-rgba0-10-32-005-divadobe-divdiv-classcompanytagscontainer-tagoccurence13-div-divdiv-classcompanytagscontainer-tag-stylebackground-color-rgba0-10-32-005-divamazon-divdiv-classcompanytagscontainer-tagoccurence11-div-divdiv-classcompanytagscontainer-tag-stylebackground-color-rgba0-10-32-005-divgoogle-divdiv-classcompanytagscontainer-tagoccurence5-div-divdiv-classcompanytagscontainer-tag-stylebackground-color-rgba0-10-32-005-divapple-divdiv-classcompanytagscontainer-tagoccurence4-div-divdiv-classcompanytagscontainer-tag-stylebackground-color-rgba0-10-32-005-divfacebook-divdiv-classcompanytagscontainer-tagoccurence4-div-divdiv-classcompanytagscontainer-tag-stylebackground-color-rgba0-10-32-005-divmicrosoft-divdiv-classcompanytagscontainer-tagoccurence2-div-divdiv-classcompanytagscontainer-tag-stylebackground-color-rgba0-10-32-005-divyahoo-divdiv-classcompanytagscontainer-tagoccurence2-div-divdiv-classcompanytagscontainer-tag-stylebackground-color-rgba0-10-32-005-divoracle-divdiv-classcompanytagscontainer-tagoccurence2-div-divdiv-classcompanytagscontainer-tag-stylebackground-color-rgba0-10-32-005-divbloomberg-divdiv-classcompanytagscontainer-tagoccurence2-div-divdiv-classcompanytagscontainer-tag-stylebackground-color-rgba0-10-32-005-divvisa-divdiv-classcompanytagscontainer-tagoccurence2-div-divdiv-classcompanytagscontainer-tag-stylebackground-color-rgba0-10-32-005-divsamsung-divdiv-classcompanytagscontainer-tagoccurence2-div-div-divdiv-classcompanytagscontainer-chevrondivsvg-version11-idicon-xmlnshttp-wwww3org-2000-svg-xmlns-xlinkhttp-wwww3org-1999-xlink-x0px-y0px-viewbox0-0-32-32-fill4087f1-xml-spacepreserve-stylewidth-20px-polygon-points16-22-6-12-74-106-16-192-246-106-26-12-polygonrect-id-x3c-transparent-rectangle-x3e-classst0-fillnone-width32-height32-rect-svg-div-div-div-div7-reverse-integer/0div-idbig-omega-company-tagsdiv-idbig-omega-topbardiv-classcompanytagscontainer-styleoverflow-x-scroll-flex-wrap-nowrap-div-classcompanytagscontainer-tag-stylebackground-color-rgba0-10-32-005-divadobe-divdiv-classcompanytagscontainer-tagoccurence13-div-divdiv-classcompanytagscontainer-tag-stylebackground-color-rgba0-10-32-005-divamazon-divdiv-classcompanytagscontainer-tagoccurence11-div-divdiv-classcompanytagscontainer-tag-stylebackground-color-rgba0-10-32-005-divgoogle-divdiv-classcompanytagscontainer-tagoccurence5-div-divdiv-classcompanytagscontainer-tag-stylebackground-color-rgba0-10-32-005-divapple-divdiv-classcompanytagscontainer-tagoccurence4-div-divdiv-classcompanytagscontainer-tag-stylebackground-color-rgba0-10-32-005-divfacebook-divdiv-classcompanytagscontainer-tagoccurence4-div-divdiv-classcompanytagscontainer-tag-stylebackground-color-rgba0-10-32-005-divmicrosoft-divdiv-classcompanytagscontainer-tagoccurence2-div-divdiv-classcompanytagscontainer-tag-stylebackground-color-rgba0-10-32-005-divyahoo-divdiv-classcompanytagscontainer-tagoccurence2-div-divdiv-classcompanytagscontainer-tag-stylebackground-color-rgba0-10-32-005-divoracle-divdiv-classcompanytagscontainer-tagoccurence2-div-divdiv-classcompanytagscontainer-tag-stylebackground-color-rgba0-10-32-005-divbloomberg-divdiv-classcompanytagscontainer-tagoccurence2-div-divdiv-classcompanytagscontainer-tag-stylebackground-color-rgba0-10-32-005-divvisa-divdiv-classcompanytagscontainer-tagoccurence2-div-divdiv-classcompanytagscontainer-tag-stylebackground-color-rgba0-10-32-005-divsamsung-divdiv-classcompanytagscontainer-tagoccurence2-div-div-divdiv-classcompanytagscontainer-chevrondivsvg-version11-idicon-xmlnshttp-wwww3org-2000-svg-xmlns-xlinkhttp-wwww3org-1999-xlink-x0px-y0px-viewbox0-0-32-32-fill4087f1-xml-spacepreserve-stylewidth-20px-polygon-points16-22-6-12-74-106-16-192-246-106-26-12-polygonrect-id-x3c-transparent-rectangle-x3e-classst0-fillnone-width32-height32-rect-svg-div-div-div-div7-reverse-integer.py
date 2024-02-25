class Solution(object):
    def reverse(self, x):
        if ((x < math.pow(-2,31)) or (x > (math.pow(2,31)) -1)):
            return 0;
        
        flag = False;
        ans = 0;
        
        if(x<0):
            flag = True;
            x = -(x);
            
        while (x>0):
            ans *= 10;
            temp = x%10;
            ans += temp;
            x = x/10;    
            
        ans = -(ans) if (flag) else ans;
            
        if ((ans < math.pow(-2,31)) or (ans > (math.pow(2,31)) -1)):
            return 0;  
            
        return ans;    
            
            
        