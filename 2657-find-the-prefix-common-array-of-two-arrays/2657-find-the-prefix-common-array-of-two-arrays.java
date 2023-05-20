class Solution {
    public int count(HashMap<Integer,Integer> map ,HashMap<Integer,Integer> temp){
        if(map.size()==0){
            return 0;
        }
        
        int ans = 0;
        
        for(int a : map.keySet()){
            if(temp.containsKey(a)){
                ans++;
            }
        }
        
        return ans;
    }
    
    public int[] findThePrefixCommonArray(int[] arr1, int[] arr2) {
        HashMap<Integer,Integer> temp = new HashMap<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[arr1.length];
        
        for(int i=0;i<arr2.length;++i){
            map.put(arr2[i],map.getOrDefault(arr2[i],0)+1);
            temp.put(arr1[i],temp.getOrDefault(arr1[i],0)+1);
            int common = count(map,temp);
            ans[i] = common;
        }
        
        return ans;
    }
}