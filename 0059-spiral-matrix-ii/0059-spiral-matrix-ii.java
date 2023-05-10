class Solution {
    public int[][] generateMatrix(int n) {
        if(n==1){
            int [][]arr = new int[1][1];
            arr[0][0] = 1;
            return arr;
        }
        
        int [][]arr = new int[n][n];
        int counter = 1;
        int rowstart = 0;
        int rowend = n-1;
        int colstart = 0;
        int colend = n-1;
        
      while(rowstart<=rowend && colstart<=colend){
          for(int j=colstart;j<=colend;++j){
              arr[rowstart][j] = counter;
              counter++;
          }
          rowstart++;
          
          for(int i=rowstart;i<=rowend;++i){
              arr[i][colend] = counter;
              counter++;
          }
          colend--;
          
          for(int j=colend;j>=colstart;--j){
              arr[rowend][j] = counter;
              counter++;
          }
          rowend--;
          
          for(int i=rowend;i>=rowstart;--i){
              arr[i][colstart] = counter;
              counter++;
          }
          colstart++;
      }
        
        return arr;
    }
}