class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        int i=0;
        while(i<arr.length){
            int correctP = arr[i]-1;
            if(arr[i]!=arr[correctP]){
                int temp = arr[i];
                arr[i] = arr[correctP];
                arr[correctP] =temp;
            }
            else{
                i++;
            }
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        for(int j=0;j<arr.length;j++){
            if(arr[j]!=j+1){
                ans.add(j+1);
            }
        }
        return ans;
    }
}