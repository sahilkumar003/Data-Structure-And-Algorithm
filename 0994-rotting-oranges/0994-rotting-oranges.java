class Solution {
    class Pair{
        int row;
        int col;
        int time;
        
        public Pair(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    
    public int orangesRotting(int[][] grid) {
       int rowLength = grid.length;
        int colLength = grid[0].length;
        
        Queue<Pair> q = new LinkedList<>();
        int [][]visited = new int[rowLength][colLength];
        
        for(int i=0;i<rowLength;++i){
            for(int j=0;j<colLength;++j){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j,0));
                    visited[i][j] = 2;
                }else{
                    visited[i][j] = 0;
                }
            }
        }
        
        int maxTime = 0;
        int []rowC = {-1,0,1,0};
        int []colC = {0,1,0,-1};
        
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int time = q.peek().time;
            
            maxTime = Math.max(maxTime,time);
            
            q.remove();
            
            for(int i=0;i<4;++i){
                int nRow = row+rowC[i];
                int nCol = col+colC[i];
                
                if(nRow>=0 && nRow<rowLength && nCol>=0 && nCol<colLength && grid[nRow][nCol]==1 && visited[nRow][nCol]==0){
                    q.add(new Pair(nRow,nCol,time+1));
                    visited[nRow][nCol] = 2;
                }
            }
            
        }
        
        for(int i=0;i<rowLength;++i){
            for(int j=0;j<colLength;++j){
                if(grid[i][j]==1 && visited[i][j]!=2){
                    return -1;
                }
            }
        }
        
        
        return maxTime; 
   }
}