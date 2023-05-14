class Solution {
    public int[] circularGameLosers(int n, int k) {
        int []arr = new int[n];
        boolean []check = new boolean[n];
        
        for(int i=0;i<n;++i){
            arr[i] = i+1;
        }
        
        int j = 0;
        int i = 1;
        int pass = 0;
        check[0] = true;
        
        while(true){
            pass = i*k;
            j = j+pass;
            j %= n;
            i++;
            
            if(!check[j]){
                check[j] = true;
            }else{
                break;
            }
            
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int z=0;z<n;++z){
            if(!check[z]){
                list.add(arr[z]);
            }
        }
        
        int[] ans = list.stream().mapToInt(a -> a).toArray();
        
        return ans;
        
    }
}