class Solution {
    public int jump(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        
       int current = 0;
       int maxPossible = 0;
       int jump = 0; 
        
        for(int i=0;i<arr.length-1;++i){
            maxPossible = Math.max(maxPossible,i+arr[i]);
            
            if(maxPossible>=arr.length-1){
                return jump+1;
            }
            
            if(i==current){
                current = maxPossible;
                jump++;
            }
            
        }
        
        return jump;
    }
}