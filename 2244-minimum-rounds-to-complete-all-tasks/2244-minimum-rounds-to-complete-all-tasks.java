class Solution {
    public int minimumRounds(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }

        int rounds = 0;

        for(int a : map.values()){
            if(a==1){
                return -1;
            }
            int temp = a/3;
            if(a%3 == 0){
                rounds += temp;
            }else{
                rounds += temp + 1;
            }
        }
        return rounds;
    }
}