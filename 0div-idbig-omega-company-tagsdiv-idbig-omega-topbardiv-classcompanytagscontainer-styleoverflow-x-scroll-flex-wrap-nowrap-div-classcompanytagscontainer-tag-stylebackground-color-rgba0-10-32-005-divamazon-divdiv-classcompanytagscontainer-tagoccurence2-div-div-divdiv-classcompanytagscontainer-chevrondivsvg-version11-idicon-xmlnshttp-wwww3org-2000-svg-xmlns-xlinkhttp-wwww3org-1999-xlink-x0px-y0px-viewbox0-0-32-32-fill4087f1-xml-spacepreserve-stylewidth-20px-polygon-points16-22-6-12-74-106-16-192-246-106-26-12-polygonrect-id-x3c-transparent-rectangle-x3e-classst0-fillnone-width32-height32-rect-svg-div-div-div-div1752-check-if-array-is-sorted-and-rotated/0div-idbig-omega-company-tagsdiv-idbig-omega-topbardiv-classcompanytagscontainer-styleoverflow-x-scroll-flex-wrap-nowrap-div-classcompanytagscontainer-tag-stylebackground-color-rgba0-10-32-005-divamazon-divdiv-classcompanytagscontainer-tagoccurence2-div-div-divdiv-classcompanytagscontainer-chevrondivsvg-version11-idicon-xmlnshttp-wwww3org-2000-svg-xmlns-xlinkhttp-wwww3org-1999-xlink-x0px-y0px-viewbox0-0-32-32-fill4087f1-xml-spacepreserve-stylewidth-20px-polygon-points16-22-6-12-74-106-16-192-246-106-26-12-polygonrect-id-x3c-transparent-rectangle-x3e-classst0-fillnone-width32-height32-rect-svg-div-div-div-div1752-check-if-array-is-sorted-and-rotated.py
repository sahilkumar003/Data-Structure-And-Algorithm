class Solution:
    def check(self, nums: List[int]) -> bool:
        new_point = -1;
        list_length = len(nums)
        for index in range(1, list_length):
            if nums[index] < nums[index-1]:
                new_point = index
                break
        
        if(new_point != -1):
            temp_point = (new_point + 1) % list_length;
            while(temp_point!=new_point):
                if(nums[temp_point] < nums[temp_point-1]):
                    return False
                temp_point = (temp_point + 1) % list_length;
                
        return True        