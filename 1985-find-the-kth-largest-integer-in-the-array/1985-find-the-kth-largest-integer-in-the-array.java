class Solution {
    public String kthLargestNumber(String[] arr, int k) {
        
         PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
            if (s1.length() == s2.length()) 
                return s1.compareTo(s2);
            else
                return Integer.compare(s1.length(), s2.length());
        });
        for(int i=0;i<k;++i){
            pq.add(arr[i]);
        }

        for(int i=k;i<arr.length;++i){
           pq.add(arr[i]);
            if(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();
    }
}