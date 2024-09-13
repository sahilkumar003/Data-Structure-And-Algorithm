class Solution {
    public boolean isDivisible(int []arr, int k){
        int [] memo = new int[k];
        
        for (int i=0;i<arr.length;++i){
            int remainder = ((arr[i] % k) + k) % k;
            memo[remainder]++;
        }
        
        for (int i=0;i<=k/2;++i){
           if (i==0 && memo[i]%2!=0){
               return false;
           }else{
               int y = k-i;
               y = ((y % k) + k) % k;
               if(memo[i]!=memo[y]){
                   return false;
               }
           }
        }
        
        return true;
    }
    
    public boolean canArrange(int[] arr, int k) {
        return isDivisible(arr, k);
    }
}