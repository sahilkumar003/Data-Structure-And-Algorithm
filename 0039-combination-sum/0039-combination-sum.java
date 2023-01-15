class Solution {
    public List<List<Integer>> solution(int[] arr, int target, int index, ArrayList<Integer> list, List<List<Integer>> ans) {
        if(index==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return ans;
        }

        if(arr[index]<=target){
            list.add(arr[index]);
            solution(arr,target-arr[index],index,list,ans);
            list.remove(list.size()-1);
        }

        solution(arr,target,index+1,list,ans);

        return ans;
    }
    
    public List<List<Integer>> combinationSum(int[] arr, int target) {
        return solution(arr,target,0,new ArrayList<>(),new ArrayList<>());
    }
}