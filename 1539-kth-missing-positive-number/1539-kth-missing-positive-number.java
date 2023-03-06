class Solution {
    public int findKthPositive(int[] arr, int k) {
//         ArrayList<Integer> list = new ArrayList<>();
//         HashMap<Integer,Integer> map = new HashMap<>();

//         for(int i=0;i<arr.length;i++){
//             map.put(arr[i],map.getOrDefault(arr[i],0)+1);
//         }

//         for(int i=1;i<=100000;i++){
//             if(map.containsKey(i)){
//                 continue;
//             }else{
//                 list.add(i);
//             }

//             if(list.size()==k){
//                 break;
//             }
//         }
//         return list.get(k-1);
        
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]<=k){
                k++;
            }else{
                break;
            }
        }
        return k;
   }
}