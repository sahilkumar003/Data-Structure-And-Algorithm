class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int []ans = new int[arr.length-k+1];
        Deque<Integer> q = new ArrayDeque<>();
        int j = 0;

        for(int i=0;i<arr.length;i++){
            if(i<k){
                while(!q.isEmpty() && arr[i]>=arr[q.peekLast()]){
                    q.removeLast();
                }
                q.addLast(i);
            }else{
                ans[j++] = arr[q.peekFirst()];
                while(!q.isEmpty() && q.peekFirst()==i-k){
                    q.removeFirst();
                }
                while(!q.isEmpty() && arr[i]>=arr[q.peekLast()]){
                    q.removeLast();
                }
                q.addLast(i);
            }
        }
        ans[j] = arr[q.peekFirst()];
        return ans;
        
    }
}