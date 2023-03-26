class Solution {
    public int titleToNumber(String str) {
        long product = ((str.charAt(0) - 'A') + 1);
        
        for(int i=1;i<str.length();++i){
            product *= 26;
            product += ((str.charAt(i) - 'A') + 1);
        }
        
        return (int)product;
    }
}