class Solution {
    public int distributeCandies(int[] arr) {
        Arrays.sort(arr);
        int candy = 1;
        int require = arr.length/2;
        
        for(int i=1; i<arr.length;++i){
            if(arr[i] != arr[i-1]){
                candy++;
            }
        }
        
        return Math.min(candy,require);
    }
}