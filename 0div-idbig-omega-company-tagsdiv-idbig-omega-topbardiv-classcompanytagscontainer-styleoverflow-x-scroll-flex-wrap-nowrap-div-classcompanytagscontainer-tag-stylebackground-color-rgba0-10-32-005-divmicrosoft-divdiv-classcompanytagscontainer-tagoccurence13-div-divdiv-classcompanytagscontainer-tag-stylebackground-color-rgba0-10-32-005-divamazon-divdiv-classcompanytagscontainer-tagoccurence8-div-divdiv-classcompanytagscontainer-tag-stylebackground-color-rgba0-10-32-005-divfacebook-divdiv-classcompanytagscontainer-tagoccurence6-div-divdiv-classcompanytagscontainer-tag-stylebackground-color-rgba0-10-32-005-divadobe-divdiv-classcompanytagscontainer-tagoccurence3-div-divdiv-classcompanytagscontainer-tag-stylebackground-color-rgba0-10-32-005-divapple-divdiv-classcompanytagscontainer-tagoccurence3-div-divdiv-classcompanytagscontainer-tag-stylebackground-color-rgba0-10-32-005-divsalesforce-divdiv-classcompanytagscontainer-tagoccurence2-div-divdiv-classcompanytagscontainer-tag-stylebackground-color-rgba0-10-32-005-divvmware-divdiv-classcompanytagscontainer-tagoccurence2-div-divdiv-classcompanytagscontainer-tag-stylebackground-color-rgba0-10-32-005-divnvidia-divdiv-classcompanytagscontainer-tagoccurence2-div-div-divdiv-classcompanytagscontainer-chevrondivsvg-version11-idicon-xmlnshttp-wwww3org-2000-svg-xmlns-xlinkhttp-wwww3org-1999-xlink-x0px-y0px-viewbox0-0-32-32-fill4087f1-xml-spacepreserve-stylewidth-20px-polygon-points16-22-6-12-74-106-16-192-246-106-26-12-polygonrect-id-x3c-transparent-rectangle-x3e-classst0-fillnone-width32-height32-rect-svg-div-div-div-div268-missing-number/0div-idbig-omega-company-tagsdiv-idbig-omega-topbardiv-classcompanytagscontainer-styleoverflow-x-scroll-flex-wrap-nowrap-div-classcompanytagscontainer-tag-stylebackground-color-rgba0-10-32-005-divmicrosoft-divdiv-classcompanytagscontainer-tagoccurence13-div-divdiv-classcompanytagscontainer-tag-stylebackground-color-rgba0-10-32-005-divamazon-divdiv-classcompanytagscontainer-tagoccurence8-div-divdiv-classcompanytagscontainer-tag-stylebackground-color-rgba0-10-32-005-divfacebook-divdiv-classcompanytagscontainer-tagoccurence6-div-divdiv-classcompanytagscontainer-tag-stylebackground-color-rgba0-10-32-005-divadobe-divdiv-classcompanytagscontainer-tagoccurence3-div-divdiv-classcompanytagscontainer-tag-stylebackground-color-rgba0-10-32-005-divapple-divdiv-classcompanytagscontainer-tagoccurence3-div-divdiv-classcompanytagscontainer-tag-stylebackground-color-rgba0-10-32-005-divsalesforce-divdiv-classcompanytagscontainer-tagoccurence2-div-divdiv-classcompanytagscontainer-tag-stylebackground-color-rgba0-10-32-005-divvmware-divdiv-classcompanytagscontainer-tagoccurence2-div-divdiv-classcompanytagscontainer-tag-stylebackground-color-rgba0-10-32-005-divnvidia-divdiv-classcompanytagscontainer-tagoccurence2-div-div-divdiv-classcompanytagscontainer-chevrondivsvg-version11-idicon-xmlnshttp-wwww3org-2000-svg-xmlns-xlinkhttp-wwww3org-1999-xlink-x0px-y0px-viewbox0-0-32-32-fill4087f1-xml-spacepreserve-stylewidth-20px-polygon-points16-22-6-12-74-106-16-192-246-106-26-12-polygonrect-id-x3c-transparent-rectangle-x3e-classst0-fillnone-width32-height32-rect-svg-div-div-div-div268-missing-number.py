class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        sum_of_first_n = int((len(nums) * (len(nums) + 1)) / 2)
        for index in range(len(nums)):
            sum_of_first_n = sum_of_first_n - nums[index]
            
        return sum_of_first_n    