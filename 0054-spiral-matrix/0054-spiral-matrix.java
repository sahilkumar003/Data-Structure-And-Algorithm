class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer>  list = new ArrayList<>();
        
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        
        while(rowStart<=rowEnd && colStart<=colEnd){
            for(int j=colStart;j<=colEnd;++j){
                list.add(matrix[rowStart][j]);
            }
            rowStart++;
            
            for(int i=rowStart;i<=rowEnd;++i){
                list.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowStart<=rowEnd){
            for(int j=colEnd;j>=colStart;--j){
                list.add(matrix[rowEnd][j]);
            }
            rowEnd--;
            }
            
            if(colStart<=colEnd){
            for(int i=rowEnd;i>=rowStart;--i){
                list.add(matrix[i][colStart]);
            }
            colStart++;
            }
        }
        
        return list;
    }
}