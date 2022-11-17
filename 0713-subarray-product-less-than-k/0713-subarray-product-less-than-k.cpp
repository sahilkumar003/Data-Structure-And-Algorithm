class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
         int i = 0;
        int j = 0;
        int ans=0;
        int curr_product = 1;
        int n = nums.size();
        while(i<n)
        {
            curr_product *= nums[i++];
            while(curr_product>=k && j<i)
            {
                curr_product /= nums[j++];
            }       
            ans += i-j;
        }
        return ans;
    }
};