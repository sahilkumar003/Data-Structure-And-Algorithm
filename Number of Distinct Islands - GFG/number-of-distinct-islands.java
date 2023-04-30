//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(int row, int col, boolean[][]visited, int [][]grid, ArrayList<String> list,int srow, int scol){
        visited[row][col] = true;;
        list.add(convertToString(row-srow,col-scol));
        
        int n = grid.length;
        int m = grid[0].length;
        
        int []rowc = {-1,0,1,0};
        int []colc = {0,-1,0,1};
        
        for(int i=0;i<4;++i){
            int nrow = row+rowc[i];
            int ncol = col+colc[i];
            
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !visited[nrow][ncol] && grid[nrow][ncol]==1){
                dfs(nrow,ncol,visited,grid,list,srow,scol);
            }
        }
    } 
    
    String convertToString(int row,int col){
        return Integer.toString(row) + " " + Integer.toString(col);
    }
    

    int countDistinctIslands(int[][] grid) {
     int n = grid.length;
     int m = grid[0].length;
     
     HashSet<ArrayList<String>> set = new HashSet<>();
     boolean [][]visited  = new boolean[n][m];
     
     for(int i=0;i<n;++i){
         for(int j=0;j<m;++j){
             if(grid[i][j] == 1 && !visited[i][j]){
                 ArrayList<String> list = new ArrayList<>();
                 dfs(i,j,visited,grid,list,i,j);
                 set.add(list);
             }
         }
     }
        return set.size();
    }
}
