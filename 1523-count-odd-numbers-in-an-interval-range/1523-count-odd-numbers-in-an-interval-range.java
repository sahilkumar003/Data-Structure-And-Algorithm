class Solution {
    public int countOdds(int low, int high) {
        int temp = high-low;
        if(low%2==0 && high%2==0){
            return temp/2;
        }else{
             return temp/2 + 1;
        }
    }
}