class Solution {
    public ArrayList<Integer> primeSet(int n){
        boolean []arr = new boolean[n+1];
        Arrays.fill(arr,true);
        ArrayList<Integer> list = new ArrayList<>();
        
         for(int i = 2; i*i <=n; ++i){
            if(arr[i] == true)
            {
                for(int j = i*i; j <= n; j += i)
                    arr[j] = false;
            }
        }
         
        for(int i = 2; i <= n; i++){
            if(arr[i] == true){
                list.add(i);
            }
        }
        return list;
    }
    
    public int closePrime(ArrayList<Integer> list, int a, int b){
        int ans = 0;
        
        for(int temp : list){
            if(a-temp<=b){
                break;
            }
            ans = temp;
        }
        return a-ans;
    }
    
    public boolean primeSubOperation(int[] arr) {
        ArrayList<Integer> list = primeSet(1000);
        boolean []check = new boolean[arr.length];
        arr[0] = closePrime(list,arr[0],0);
        
            for(int i=1;i<arr.length;++i){
                arr[i] = closePrime(list,arr[i],arr[i-1]);
            }
            
            for(int i=1;i<arr.length;++i){
                if(arr[i]<=arr[i-1]){
                    return false;
                }
            }
        return true;
    }
}