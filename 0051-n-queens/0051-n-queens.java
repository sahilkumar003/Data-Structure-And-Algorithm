class Solution {
//         public boolean validate(int col, int row, char[][] board){
//         int tempRow = row;
//         int tempCol = col;

//         while(row>=0 && col>=0){
//             if(board[row][col] == 'Q'){
//                 return false;
//             }
//             row--;
//             col--;
//         }

//         row = tempRow;
//         col = tempCol;

//         while(col>=0){
//             if(board[row][col] == 'Q'){
//                 return false;
//             }
//             col--;
//         }

//         row = tempRow;
//         col = tempCol;

//         while (row<board.length && col>=0){
//             if(board[row][col] == 'Q'){
//                 return false;
//             }
//             row++;
//             col--;
//         }

//         return true;
//     }

//     public List<String> construct(char[][] board){
//         List<String> temp = new ArrayList<>();
//         for(int i=0;i<board.length;++i){
//             String s = new String(board[i]);
//             temp.add(s);
//         }
//         return temp;
//     }

//     public List<List<String>> solution(int col, char[][] board, List<List<String>> ans, int n){
//         if(col == n){
//             ans.add(construct(board));
//             return ans;
//         }

//         for(int row=0;row<n;++row){
//             if(validate(col,row,board)){
//                 board[row][col] = 'Q';
//                 solution(col+1,board,ans,n);
//                 board[row][col] = '.';
//             }
//         }

//         return ans;
//     }
    
//     public List<List<String>> solveNQueens(int n) {
//         char [][] board = new char[n][n];
//         for(int i=0;i<board.length;++i){
//             for(int j=0;j<board.length;++j){
//                 board[i][j] = '.';
//             }
//         }

//         return solution(0,board,new ArrayList<>(),n);
//     }
    
    
    
    public List<String> construct(char[][] board){
        List<String> temp = new ArrayList<>();
        for(int i=0;i<board.length;++i){
            String s = new String(board[i]);
            temp.add(s);
        }
        return temp;
    }

    public List<List<String>> solution(int col, char[][] board, List<List<String>> ans, int[] leftRow,                                                                        int[] upperLeft, int[] lowerLeft){
        if(col == board.length){
            ans.add(construct(board));
            return ans;
        }

        for(int row=0;row<board.length;++row){
            if(leftRow[row]==0 && upperLeft[board.length- 1 + col - row]==0 && lowerLeft[row+col]==0){
                board[row][col] = 'Q';
                leftRow[row]= 1;
                lowerLeft[row+col] = 1;
                upperLeft[board.length-1 + col-row] = 1;
                solution(col+1,board,ans,leftRow,upperLeft,lowerLeft);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerLeft[row+col] = 0;
                upperLeft[board.length-1 + col-row] = 0;
            }
        }

        return ans;
    }

    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char[n][n];
        for(int i=0;i<board.length;++i){
            for(int j=0;j<board.length;++j){
                board[i][j] = '.';
            }
        }

        int[] leftRow = new int[n];
        int[] upperLeft = new int[2*n - 1];
        int[] lowerLeft = new int[2*n - 1];

        return solution(0,board,new ArrayList<>(),leftRow,upperLeft,lowerLeft);
    }
}