class Solution {
    public static void permutationAns(int []nums, boolean []arr, List<List<Integer>> ans, List<Integer> ds){
        if(ds.size()==nums.length){
           if(!ans.contains(ds)){
               ans.add(new ArrayList<>(ds));
           }
            return;
        }

        for(int i=0;i<nums.length;++i){
            if(!arr[i]){
                arr[i] = true;
                ds.add(nums[i]);
                permutationAns(nums,arr,ans,ds);
                ds.remove(ds.size()-1);
                arr[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean []arr = new boolean[nums.length];

        permutationAns(nums,arr,ans,ds);
        
        return ans;
    }
}