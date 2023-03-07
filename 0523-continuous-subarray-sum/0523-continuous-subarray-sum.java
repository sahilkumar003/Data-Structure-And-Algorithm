class Solution {
    public boolean checkSubarraySum(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        int rem = 0;
        
        for(int i=0;i<arr.length;++i){
            sum += arr[i];
            rem = sum%k;
            if(rem<0){
                rem += k;
            }
            if(map.containsKey(rem)){
                int length = i-map.get(rem);
                if(length>=2){
                    return true;
                }
            }else{
            map.put(rem,i);
            }
        }
        
        return false;
    }
}