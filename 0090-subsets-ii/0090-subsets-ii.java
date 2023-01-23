class Solution {
    public List<List<Integer>> solution(int index, int []arr, List<Integer> ds, List<List<Integer>>ans){
        if(index == arr.length){
            if(!ans.contains(ds)){
                ans.add(new ArrayList<>(ds));
            }
            return ans;
        }
        
        ds.add(arr[index]);
        solution(index+1,arr,ds,ans);
        ds.remove(ds.size()-1);
        
        solution(index+1,arr,ds,ans);
        
        return ans;
    }
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return solution(0,nums,new ArrayList<>(),new ArrayList<>());
    }
}