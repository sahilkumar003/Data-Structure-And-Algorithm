class Solution {
  public List<List<Integer>> solution(int index, int []arr, List<List<Integer>> ans){
        if(index == arr.length){
            ArrayList<Integer> ds = new ArrayList<>();
            for(int i=0;i<arr.length;++i){
                ds.add(arr[i]);
            }
            ans.add(new ArrayList<>(ds));

            return ans;
        }

        for(int i=index;i<arr.length;++i){
            swap(index,i,arr);
            solution(index+1,arr,ans);
            swap(index,i,arr);
        }

        return ans;
    }

    public int[] swap(int i, int j, int []arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return arr;
    }    
    
    public List<List<Integer>> permute(int[] nums) {
        return solution(0,nums,new ArrayList<>());
    }
}