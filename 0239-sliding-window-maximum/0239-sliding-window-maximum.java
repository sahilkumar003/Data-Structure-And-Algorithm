class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int []answer = new int[arr.length-k+1];
        int counter = 0;
        Deque<Integer> dq = new ArrayDeque<Integer>();
        
        for(int i=0;i<arr.length;++i){
            if(i<k){
                while(!dq.isEmpty() && arr[i]>=arr[dq.getLast()]){
                    dq.removeLast();
                }
                dq.addLast(i);
            }else{
                answer[counter++] = arr[dq.getFirst()];
                 while(!dq.isEmpty() && arr[i]>=arr[dq.getLast()]){
                    dq.removeLast();
                }
                while(!dq.isEmpty() && dq.getFirst()<=i-k){
                    dq.removeFirst();
                }
                 dq.addLast(i);
            }
        }
        
        answer[counter] = arr[dq.getFirst()];
        return answer;
    }
}