class Solution(object):
    def isPalindrome(self, x):
        if (x<0):
            return False;
        
        original = int(x);
        ans = 0;
        
        while(x>0):
            ans *= 10;
            temp = x%10;
            ans += temp;
            x /= 10;
        
        return True if (ans==original) else False;
            