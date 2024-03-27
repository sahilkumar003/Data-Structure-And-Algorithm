class Solution {
    public int maxFrequency(int[] nums, int k) {
//         Arrays.sort(nums);
        
//         int leftPointer = 0;
//         int maximumPossibleFrequency = 1;
//         long windowSum = 0;
        
//         for(int rightPointer=0;rightPointer<nums.length;rightPointer++){
//             windowSum += nums[rightPointer];
            
//             while((long )(nums[rightPointer] * (rightPointer - leftPointer + 1)) > (windowSum + k)){
//                 windowSum -= nums[leftPointer];
//                 leftPointer++;
//             }
            
//             maximumPossibleFrequency = Math.max(maximumPossibleFrequency, rightPointer - leftPointer + 1);
//         }
        
//         return maximumPossibleFrequency;
        
        
         int maxFrequency = 0; // Initialize the maximum frequency
        long currentSum = 0; // Initialize the current sum of the subarray elements

        Arrays.sort(nums); // Sort the array in ascending order

        for (int left = 0, right = 0; right < nums.length; ++right) {
            currentSum += nums[right]; // Include the current element in the subarray sum

            // Check if the current subarray violates the condition (sum + k < nums[right] * length)
            while (currentSum + k < (long) nums[right] * (right - left + 1)) {
                currentSum -= nums[left]; // Adjust the subarray sum by removing the leftmost element
                left++; // Move the left pointer to the right
            }

            // Update the maximum frequency based on the current subarray length
            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}