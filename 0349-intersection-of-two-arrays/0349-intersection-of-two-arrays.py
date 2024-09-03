class Solution:
    def findIntersection(self, nums1, nums2):
        ans = []
        for num in nums2:
            if num in nums1 and num not in ans:
                ans.append(num)
        
        return ans;
    
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return self.findIntersection(nums1, nums2);