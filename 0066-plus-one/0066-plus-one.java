class Solution {
    public int[] plusOne(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int carry = (arr[arr.length-1] + 1)/10;
        int temp = (arr[arr.length-1] + 1)%10;
        
        for(int i=arr.length-2;i>=0;--i){
            list.add(temp);
            temp = (arr[i] + carry)%10;
            carry =  (arr[i] + carry)/10;
        }
        
        list.add(temp);
        
        if(carry != 0){
            list.add(carry);
        }
        
        Collections.reverse(list);
        
        int[] ans = list.stream().mapToInt(i -> i).toArray();
        return ans;
    }
}