class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        
        if(costs[0]>coins){
            return 0;
        }
        
        int iceCream = 0;
        int sum = 0; 
        
        for(int i=0;i<costs.length;++i){
            sum += costs[i];
            if(sum<=coins){
                iceCream++;
            }else{
                break;
            }
        }
        
        return iceCream;
    }
}