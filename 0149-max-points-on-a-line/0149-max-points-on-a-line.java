class Solution {
    public int maxPoints(int[][] arr) {
        

        int ans = 0;

        for(int i=0;i<arr.length;++i){
            HashMap<Double,Integer> map = new HashMap<>();
            for(int j=0;j<arr.length;++j){
                if(i!=j){
                    int x = arr[i][0]-arr[j][0];
                    int y = arr[i][1]-arr[j][1];

                    if(x!=0){
                        double temp = (double) y/(double)x;
                        map.put(temp,map.getOrDefault(temp,0)+1);
                        ans = Math.max(ans,map.get(temp));
                    }else{
                        if(arr[i][0]==arr[j][0]){
                            double temp = 100000;
                             map.put(temp,map.getOrDefault(temp,0)+1);
                             ans = Math.max(ans,map.get(temp));
                        }
                    }
                }
            }
        }

        return ans+1;
    }
}