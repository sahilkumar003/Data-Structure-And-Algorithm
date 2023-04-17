class Solution {
    public List<Boolean> kidsWithCandies(int[] arr, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        
        int max = Arrays.stream(arr).max().getAsInt();
        
        for(int i=0;i<arr.length;++i){
            if((arr[i]+extraCandies)>=max){
                list.add(true);
            }else{
                list.add(false);
            }
        }
        return list;
    }
}