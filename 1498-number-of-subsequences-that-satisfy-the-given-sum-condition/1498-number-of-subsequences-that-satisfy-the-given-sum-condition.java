class Solution {
//    public void ans(int []arr, int index, int target, ArrayList<Integer> ds, ArrayList<Integer> ans){
//         if(index==arr.length){
//             if(ds.size()!=0){
//                 int min = Collections.min(ds);
//                 int max = Collections.max(ds);
//                 if(min+max<=target){
//                     ans.add(1);
//                 }
//             }
//             return ;
//         }

//         ds.add(arr[index]);

//         ans(arr,index+1,target,ds,ans);

//         ds.remove(ds.size()-1);

//         ans(arr,index+1,target,ds,ans);

//     }
    
    
    public int numSubseq(int[] nums, int target) {
//         ArrayList<Integer> ds = new ArrayList<>();
        
//         ArrayList<Integer> ans = new ArrayList<>();
        
//         ans(nums,0,target,ds,ans);

//         return ans.size()%1000000007;
        
       final int MOD = 1000000007;
        int length=nums.length;
        Arrays.sort(nums);
        int[] pow = new int[length + 1];
        pow[0] = 1;
        
        for (int i = 1; i <= length; ++i){
            pow[i] = (pow[i - 1] * 2) % MOD;
        }
        
        int l=0;
        int r=length-1;
        int ans=0;
        
        while(l<=r){
            if(nums[l]+nums[r]<=target){
                ans=(ans+pow[r-l])%MOD;
                l++;
            }else{
                r--;
            }
        }
       
        return ans;
    }
}