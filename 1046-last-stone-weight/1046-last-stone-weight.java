class Solution {
    public int lastStoneWeight(int[] arr) {
        if(arr.length==1){
            return arr[0];
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<arr.length;++i){
            pq.add(arr[i]);
        }
        
        while(pq.size()>1){
            int a = pq.remove();
            int b = pq.remove();
            
            if(a!=b){
             pq.add((int)Math.abs(a-b));   
            }
        }
        
        return pq.size()==0 ? 0 : pq.remove();
    }
}