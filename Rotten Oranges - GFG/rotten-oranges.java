//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
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
    
    public int orangesRotting(int[][] grid)
    {
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