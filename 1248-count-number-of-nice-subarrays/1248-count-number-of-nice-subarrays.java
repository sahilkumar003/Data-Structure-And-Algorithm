class Solution {
    public int numberOfSubarrays(int[] arr, int k) {
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2!=0){
                arr[i] = 1;
            }else{
                arr[i]= 0;
            }
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for(int i=0;i<arr.length;i++){
            sum += arr[i];
            int target = sum-k;
            
            if(map.containsKey(target)){
                count += map.get(target);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}