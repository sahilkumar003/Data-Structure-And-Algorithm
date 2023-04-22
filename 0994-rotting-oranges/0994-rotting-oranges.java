class Solution {
    public int orangesRotting(int[][] arr) {
        int time = 0;
        boolean flag1 = false;
        boolean flag2 = false;
        
        for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr[0].length;++j){
                if(arr[i][j]==1){
                   flag1 = true;
                }
                if(arr[i][j]==2){
                    flag2 = true;
                }
            }
        }
        
        if(!flag1){
            return 0;
        }
        
        if(!flag2){
            return -1;
        }
        
        while(true){
         boolean [][] temp = new boolean[arr.length][arr[0].length];
            boolean flag = false;
            boolean one = false;
          for(int i=0;i<arr.length;++i){
            for(int j=0;j<arr[0].length;++j){
                if(arr[i][j]==1){
                    one = true;
                }
                if(!temp[i][j] && arr[i][j]==2){
                    if(i-1>=0 && !temp[i-1][j] && arr[i-1][j]==1){
                        arr[i-1][j] = 2;
                        temp[i-1][j] = true;
                        flag = true;
                    }
                     if(j+1<arr[0].length && !temp[i][j+1] && arr[i][j+1]==1){
                        arr[i][j+1] = 2;
                        temp[i][j+1] = true;
                         flag = true;
                    }
                     if(j-1>=0 && !temp[i][j-1] && arr[i][j-1]==1){
                        arr[i][j-1] = 2;
                        temp[i][j-1] = true;
                         flag = true;
                    }
                     if(i+1<arr.length && !temp[i+1][j] && arr[i+1][j]==1){
                        arr[i+1][j] = 2;
                        temp[i+1][j] = true;
                         flag = true;
                    }
                }
            }
        }
             if(flag){
                  time++;
              }else{
                 if(!one){
                  return time;
                 }else{
                     return -1;
                 }
              } 
         } 
   }
}