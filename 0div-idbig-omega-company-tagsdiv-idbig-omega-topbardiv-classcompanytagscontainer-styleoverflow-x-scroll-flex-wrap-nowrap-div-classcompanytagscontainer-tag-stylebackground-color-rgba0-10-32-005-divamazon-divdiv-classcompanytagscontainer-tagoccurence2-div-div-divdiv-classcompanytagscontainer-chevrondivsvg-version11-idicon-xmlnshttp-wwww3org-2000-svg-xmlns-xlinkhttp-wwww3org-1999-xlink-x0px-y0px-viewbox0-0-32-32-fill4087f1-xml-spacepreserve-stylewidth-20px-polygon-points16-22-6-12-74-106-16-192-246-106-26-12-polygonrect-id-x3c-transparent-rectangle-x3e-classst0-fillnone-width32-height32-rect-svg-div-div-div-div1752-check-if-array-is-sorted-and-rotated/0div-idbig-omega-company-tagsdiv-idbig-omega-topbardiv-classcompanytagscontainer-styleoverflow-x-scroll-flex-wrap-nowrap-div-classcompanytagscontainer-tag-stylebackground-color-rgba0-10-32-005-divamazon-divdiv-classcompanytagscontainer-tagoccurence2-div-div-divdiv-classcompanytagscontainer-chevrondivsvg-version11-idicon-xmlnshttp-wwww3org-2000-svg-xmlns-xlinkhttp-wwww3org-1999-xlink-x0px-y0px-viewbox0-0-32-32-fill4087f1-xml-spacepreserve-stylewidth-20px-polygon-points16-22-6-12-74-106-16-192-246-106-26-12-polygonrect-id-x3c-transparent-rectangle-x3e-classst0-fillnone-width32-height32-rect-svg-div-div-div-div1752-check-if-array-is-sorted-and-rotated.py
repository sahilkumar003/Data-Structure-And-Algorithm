class Solution:
    def check(self, nums: List[int]) -> bool:
        count = 0
        for i in range(len(nums)):
            if nums[i-1] > nums[i]:
                count += 1
        return count <= 1
        