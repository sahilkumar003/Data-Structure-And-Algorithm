class Solution {
    public int minOperations(int[] arr, int x) {
        if(arr[0]>x && arr[arr.length-1]>x){
            return -1;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
      map.put(0,-1);

      int sum = 0;
      int max = 0;

        for (int j : arr) {
            sum += j;
        }
        
        if(sum<x){
            return -1;
        }

      int req = sum - x;
      int tempSum = 0;
      
      for(int i=0;i<arr.length;++i){
           tempSum += arr[i];
           int temp = tempSum-req;

          if(map.containsKey(temp)){
              int length = i-map.get(temp);
              max =  Math.max(max,length);
          }
          map.put(tempSum,i);
      }

      return arr.length-max;
    }
}