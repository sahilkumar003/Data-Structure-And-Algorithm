class Solution {
    public int canCompleteCircuit(int[] petrol, int[] distance) {
       int []arr = new int[petrol.length];
            
       for(int i=0;i<arr.length;++i){
           arr[i] = petrol[i] - distance[i];
       }
        int deficit = 0;
        int sum = 0;
        int index = 0;
        
        for(int i=0;i<arr.length;++i){
            sum += arr[i];
            if(sum<0){
                deficit += sum;
                sum = 0;
                index = i+1;
            }
        }
        
        if((sum+deficit)>=0){
            return index;
        }
        
        
        return -1;
    }
}