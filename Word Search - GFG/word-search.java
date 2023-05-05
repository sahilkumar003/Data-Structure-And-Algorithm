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
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
       }
    }
}
// } Driver Code Ends


class Solution
{
     public boolean search(int row, int col, char[][]board,String word,boolean [][]isVisited,int counter){
        if(counter==word.length()){
            return true;
        }
        
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || isVisited[row][col] || board[row][col]!=word.charAt(counter)){
            return false;
        }
        
         isVisited[row][col] = true;
        
        boolean up = search(row-1,col,board,word,isVisited,counter+1);
        boolean down = search(row+1,col,board,word,isVisited,counter+1);
        boolean left = search(row,col-1,board,word,isVisited,counter+1);
        boolean right = search(row,col+1,board,word,isVisited,counter+1);
        
        if(up || down || left || right){
            return true;
        }
        isVisited[row][col] = false;
        
        return false;
    }
    
    public boolean isWordExist(char[][] board, String word)
    {
         int counter = 0;
        boolean [][]isVisited = new boolean[board.length][board[0].length];
        
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board[0].length;++j){
                char c = board[i][j];
                if(c==word.charAt(counter)){
                    if(search(i,j,board,word,isVisited,counter)){
                        return true;
                    }else{
                        counter = 0;
                    }
                }      
            }
        }
        return false;
    }
}