class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals.length == 1){
            return intervals;
        }
        
        Arrays.sort(intervals ,(a,b) -> {
            return a[0] != b[0] ? a[0]-b[0] : a[1]-b[1];
        });

        HashMap<Integer,Integer> map = new HashMap<>();

        int start = intervals[0][0];
        int max = intervals[0][1];
        

        for(int i=1;i<intervals.length;++i){
            if(intervals[i][0]<=max){
                max = Math.max(max,intervals[i][1]);
                start = Math.min(start,intervals[i][0]);
            }else{
                map.put(start,max);
                start = intervals[i][0];
                max = intervals[i][1];
            }

            if(i==intervals.length-1){
                map.put(start,max);
            }
        }
        
        int [][]arr = new int[map.size()][2];

        int i = 0;

        for(int x : map.keySet()){
            arr[i][0] = x;
            arr[i][1] = map.get(x);
            i++;
        }

        return arr;
    }
}