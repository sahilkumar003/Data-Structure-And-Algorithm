class Solution {
    public int[] topKFrequent(int[] arr, int k) {
     HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i=0;i<arr.length;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        
        int [][]temp = new int[map.size()][2];
        int counter = 0;
        
        for(int x : map.keySet()){
            temp[counter++][0] = x;
        }
        
        for(int i=0;i<temp.length;++i){
            temp[i][1] = map.get(temp[i][0]);
        }
        
        Arrays.sort(temp,(a,b)->{
           return b[1] - a[1];
        });
        
        counter = 0;
        
        while(k-->0){
            list.add(temp[counter++][0]);
        }
        
       int[] ans = list.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}