class Solution {
    public void sortColors(int[] arr) {
       int start = 0;
		int end = arr.length-1;
		int index = 0;
		while(index<=end) {
			//0 
			if(arr[index]==0) {
				int temp = arr[index];
				arr[index]=arr[start];
				arr[start] = temp;
				index++;
				start++;
			}
			else if(arr[index]==2) {
				int temp = arr[index];
				arr[index] = arr[end];
				arr[end] = temp;
				end--;
			}else {
				index++;
				
			}
			
		} 
    }
}