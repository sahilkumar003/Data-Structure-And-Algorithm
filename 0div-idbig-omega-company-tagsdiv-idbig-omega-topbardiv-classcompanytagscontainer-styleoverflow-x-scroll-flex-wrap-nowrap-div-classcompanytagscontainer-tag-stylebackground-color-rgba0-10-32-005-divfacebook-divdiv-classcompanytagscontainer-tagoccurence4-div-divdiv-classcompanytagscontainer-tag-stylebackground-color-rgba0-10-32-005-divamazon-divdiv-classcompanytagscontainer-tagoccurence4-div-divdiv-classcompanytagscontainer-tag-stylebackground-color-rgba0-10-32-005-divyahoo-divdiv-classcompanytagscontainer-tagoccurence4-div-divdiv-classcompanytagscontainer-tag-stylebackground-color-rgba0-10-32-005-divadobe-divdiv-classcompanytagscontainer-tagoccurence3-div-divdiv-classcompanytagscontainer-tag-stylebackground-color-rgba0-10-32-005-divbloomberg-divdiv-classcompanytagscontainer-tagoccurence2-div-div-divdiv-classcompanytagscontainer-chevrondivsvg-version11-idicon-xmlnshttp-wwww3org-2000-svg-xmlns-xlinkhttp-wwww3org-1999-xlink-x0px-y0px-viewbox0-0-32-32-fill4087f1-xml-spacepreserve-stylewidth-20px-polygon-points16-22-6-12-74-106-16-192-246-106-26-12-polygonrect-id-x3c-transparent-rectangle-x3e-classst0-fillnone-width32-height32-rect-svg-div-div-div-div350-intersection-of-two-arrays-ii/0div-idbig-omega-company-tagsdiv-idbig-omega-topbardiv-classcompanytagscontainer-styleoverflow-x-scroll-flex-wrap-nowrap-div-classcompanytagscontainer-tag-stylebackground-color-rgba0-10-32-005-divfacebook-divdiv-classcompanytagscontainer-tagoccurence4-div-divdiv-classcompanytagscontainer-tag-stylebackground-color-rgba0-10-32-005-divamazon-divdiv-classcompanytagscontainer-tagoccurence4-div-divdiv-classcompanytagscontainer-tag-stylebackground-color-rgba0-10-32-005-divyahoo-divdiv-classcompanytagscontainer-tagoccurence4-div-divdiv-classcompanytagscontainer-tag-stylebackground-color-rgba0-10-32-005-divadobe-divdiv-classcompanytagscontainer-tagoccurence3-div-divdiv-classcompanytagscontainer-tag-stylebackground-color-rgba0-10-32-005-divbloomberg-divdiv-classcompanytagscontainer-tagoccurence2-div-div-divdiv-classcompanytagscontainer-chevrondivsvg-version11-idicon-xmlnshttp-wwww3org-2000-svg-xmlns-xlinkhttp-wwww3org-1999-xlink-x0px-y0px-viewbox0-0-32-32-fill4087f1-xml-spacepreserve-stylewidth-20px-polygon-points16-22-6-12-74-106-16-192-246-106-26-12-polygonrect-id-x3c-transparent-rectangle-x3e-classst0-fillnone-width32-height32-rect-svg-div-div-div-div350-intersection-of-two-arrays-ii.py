class Solution:
    def findIntersectionArray(self, nums1, nums2):
        map = {}
        
        for nums in nums1:
            if nums in map:
                map[nums] = map[nums] + 1;
            else:
                map[nums] = 1;
                
        intersectionList = []
        
        for nums in nums2:
            if nums in map:
                intersectionList.append(nums);
                map[nums] = map[nums] - 1; 
                if map[nums] <= 0:
                    del map[nums];
                
        return intersectionList;       
    
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        return self.findIntersectionArray(nums1, nums2);