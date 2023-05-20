class Solution {
    public int maximizeSum(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<arr.length;++i){
            pq.add(arr[i]);
        }
        
        int ans = 0;
        
        while(k-->0){
            int temp = pq.remove();
            ans += temp;
            pq.add(temp+1);
        }
        
        return ans;
    }
}