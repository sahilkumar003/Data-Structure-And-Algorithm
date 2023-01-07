class Solution {
    public int canCompleteCircuit(int[] petrol, int[] distance) {
        int deficit = 0;
        int balance = 0;
        int start = 0;
        
        for(int i=0;i<petrol.length;++i){
            balance += petrol[i] - distance[i];
            if(balance<0){
                deficit += balance;
                balance = 0;
                start = i+1;
            }
        }
        if((balance+deficit)>=0){
            return start;
        }
        return -1;
    }
}