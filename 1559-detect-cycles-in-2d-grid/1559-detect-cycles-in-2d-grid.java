class Solution {
    public boolean dfs(int crow, int ccol, char target, char[][]grid, boolean[][]visited, int prow, int pcol){
        visited[crow][ccol] = true;
        int n = grid.length;
        int m = grid[0].length;
        
        int []rowc = {0,1,0,-1};
        int []colc = {1,0,-1,0};
        
        for(int i=0;i<4;++i){
            int nrow = crow + rowc[i];
            int ncol = ccol + colc[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !visited[nrow][ncol] && grid[nrow][ncol]==target){
                if(dfs(nrow,ncol,target,grid,visited,crow,ccol)) return true;
            }else if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol] && grid[nrow][ncol]==target && (nrow!=prow || ncol!=pcol)){
                return true;
            }
        }
        
        return false;
    }
    
    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                if(!visited[i][j]){
                    if(dfs(i,j,grid[i][j],grid,visited,i,j)){
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}