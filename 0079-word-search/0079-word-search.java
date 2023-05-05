class Solution {
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
    
    public boolean exist(char[][] board, String word) {
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