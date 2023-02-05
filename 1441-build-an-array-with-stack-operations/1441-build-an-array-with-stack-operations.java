class Solution {
    public List<String> buildArray(int[] target, int n) {
        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<target.length;++i){
            map.put(target[i],map.getOrDefault(target[i],0)+1);
        }
        
        
        for(int i=1;i<=n;++i){
            list.add("Push");
            
            if(!map.containsKey(i)){
                list.add("Pop");
            }
            
            if(i==target[target.length-1]){
                break;
            }
            
        }
        
        
        return list;
    }
}