class Solution {
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
         List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        
        for(int nums : arr){
            int n = outer.size();
            for(int i=0;i<n;++i){
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(nums);
                if(!outer.contains(inner)){
                    outer.add(inner);
                }
            }
        }
        
        return outer;
    }
}