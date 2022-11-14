class Solution {
    public boolean haveConflict(String[] s1, String[] s2) {
        
       int [][]arr = new int[2][2];
        
        arr[0][0] = Integer.parseInt(s1[0].replaceAll("[^0-9]", ""));
        arr[0][1] = Integer.parseInt(s1[1].replaceAll("[^0-9]", "")); 
        
        arr[1][0] = Integer.parseInt(s2[0].replaceAll("[^0-9]", ""));
        arr[1][1] = Integer.parseInt(s2[1].replaceAll("[^0-9]", ""));
        
        Arrays.sort(arr, (a,b) -> {
            return a[1] - b[1];
        });
        
        int max = arr[0][1];
        for(int i=1;i<arr.length;++i){
            if(arr[i][0]<=max){
                return true;
            }
        }
        
        return false;
    }
}