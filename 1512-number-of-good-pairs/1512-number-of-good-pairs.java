class Solution {
    public int numIdenticalPairs(int[] nums) {
                int ans = 0;
        int[] arr = new int[101];

        for(int i=0;i<nums.length;++i)
        {
            arr[nums[i]]++;
        }

        for(int i=0;i<arr.length;++i) {
            ans += (arr[i] * (arr[i] - 1)) / 2;
        }
        return ans;
    }
}