class Solution {
    public List<List<Integer>> solution(int index,int []arr, int target,List<Integer>ds,List<List<Integer>> ans){                   
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return ans;
        }

        for(int i=index;i<arr.length;++i){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }

            if(target<arr[i]){
                break;
            }

            ds.add(arr[i]);
            solution(i+1,arr,target-arr[i],ds,ans);
            ds.remove(ds.size()-1);
        }

        return ans;
    }
    
    public List<List<Integer>> combinationSum2(int[] arr, int target) {
        Arrays.sort(arr);
        return solution(0,arr,target,new ArrayList<>(),new ArrayList<>());
    }
}