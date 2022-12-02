class Solution {
     public int countSubstringForK(int[] arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        int j = -1;
        int count = 0;

        for(int i=0;i<arr.length;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(j<i && map.size()>k){
                ++j;
                if(map.get(arr[j])==1){
                    map.remove(arr[j]);
                }else{
                    map.put(arr[j],map.get(arr[j])-1);
                }
            }
            count += i-j;
        }
        return count;
    }

    public int countSubstringForK2(int []arr,int k){
        HashMap<Integer,Integer> map = new HashMap<>();

        int j = -1;
        int count = 0;

        for(int i=0;i<arr.length;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            while(j<i && map.size()>k-1){
                ++j;
                if(map.get(arr[j])==1){
                    map.remove(arr[j]);
                }else{
                    map.put(arr[j],map.get(arr[j])-1);
                }
            }
            count += i-j;
        }
        return count;
    }
    
    public int subarraysWithKDistinct(int[] arr, int k) {
    
        return (countSubstringForK(arr,k)-countSubstringForK2(arr,k));

    }
}