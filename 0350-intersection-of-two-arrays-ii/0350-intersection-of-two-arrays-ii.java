class Solution {
    public int[] intersect(int[] arr1, int[] arr2) {
         LinkedHashMap<Integer,Integer> map1 = new LinkedHashMap<>();
        LinkedHashMap<Integer,Integer> map2 = new LinkedHashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr1.length;++i){
            map1.put(arr1[i],map1.getOrDefault(arr1[i],0)+1);
        }
        
        for(int i=0;i<arr2.length;++i){
             map2.put(arr2[i],map2.getOrDefault(arr2[i],0)+1);
        }
        
        if(arr1.length > arr2.length){
            for(int x : map1.keySet()){
               if(map2.containsKey(x) && !list.contains(x)){
                    int l = (int)Math.min(map1.get(x),map2.get(x));
                   while(l-->0){
                       list.add(x);
                   }
                }
            }
        }else{
            for(int x : map2.keySet()){
                if(map1.containsKey(x)  && !list.contains(x)){
                    int l = (int)Math.min(map1.get(x),map2.get(x));
                   while(l-->0){
                       list.add(x);
                   }
                }
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}