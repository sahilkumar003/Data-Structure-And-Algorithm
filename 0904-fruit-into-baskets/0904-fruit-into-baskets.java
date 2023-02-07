class Solution {
    public int totalFruit(int[] arr) {
        if(arr.length==1 || arr.length==2){
            return arr.length;
        }
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        int j = 0;
        
        for(int i=0;i<arr.length;++i){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            sum++;
            
            if(map.size()>2){
                while(map.size()>2){
                    if(map.get(arr[j])<=1){
                        map.remove(arr[j]);
                    }else{
                        map.put(arr[j],map.get(arr[j])-1);
                    }
                    j++;
                    sum--;
                }
            }else{
                max = Math.max(max,sum);
            } 
        }
        
        return max;
    }
}