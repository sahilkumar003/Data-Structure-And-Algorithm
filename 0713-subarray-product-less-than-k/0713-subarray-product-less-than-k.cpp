class Solution {
public:
    int numSubarrayProductLessThanK(vector<int>& nums, int k) {
        int i = 0;
        int j = 0;
        int ans=0;
        int curr_product=1;
        int n=nums.size();
        while(i<n)
        {
            curr_product*=nums[i];
            //cout<<curr_product;
            while(curr_product>=k  && j<=i)
            {
                curr_product=(curr_product/nums[j]);
                j++; 
            }
            //cout<<curr_product;
            ans+=(i-j)+1;
            i++;
        }
        return ans;
    }
};