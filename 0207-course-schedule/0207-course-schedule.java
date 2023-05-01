class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<n;++i){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<prerequisites.length;++i){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int []inDegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<n;++i){
            for(Integer nodes : adj.get(i)){
                inDegree[nodes]++;
            }
        }
        
        for(int i=0;i<n;++i){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int []topo = new int[n];
        int i = 0;
        
        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            topo[i++] = node;
            
            for(Integer nodes : adj.get(node)){
                inDegree[nodes]--;
                if(inDegree[nodes]==0){
                    q.add(nodes);
                }
            }
            
        }
        
        return i==n;
    }
}