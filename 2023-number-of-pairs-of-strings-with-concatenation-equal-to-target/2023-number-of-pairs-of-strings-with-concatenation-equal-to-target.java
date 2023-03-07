class Solution {
    public int numOfPairs(String[] arr, String target) {
        HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<arr.length;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        int ans = 0;
        
        for(int i=0;i<target.length();++i){
            String a = target.substring(0,i);
            String b = target.substring(i);
            
            if(map.containsKey(a) && map.containsKey(b)){
                if(a.equals(b)){
                    ans += (map.get(a)*(map.get(a)-1));
                }else{
                    ans += (map.get(a) * map.get(b));
                }
            }
        }
        
        return ans;
    }
}