class Solution {
    public int titleToNumber(String str) {
        long product = ((str.charAt(0) - 'A') + 1);
        long sum = 0;
        
        for(int i=1;i<str.length();++i){
            product *= 26;
            sum = ((str.charAt(i) - 'A') + 1);
            product += sum;
        }
        
        return (int)(product);
    }
}