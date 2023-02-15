class Solution {
    public List<Integer> addToArrayForm(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        String num1 = "";
        
        for(int i=0;i<arr.length;++i){
            num1 += (arr[i] + "");
        }
        
        String num2 = k + "";
        
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        
        while(i>=0 && j>=0){
            int temp = (num1.charAt(i) - '0') + (num2.charAt(j) - '0') + carry;
            list.add(temp%10);
            carry = temp/10;
            i--;
            j--;
        }
        
        while(i>=0){
            int temp = (num1.charAt(i) - '0') + carry;
            list.add(temp%10);
            carry = temp/10;
            i--;
        }
        
        while(j>=0){
            int temp = (num2.charAt(j) - '0') + carry;
            list.add(temp%10);
            carry = temp/10;
            j--;
        }
        
        if(carry!=0){
            list.add(carry);
        }
        
        Collections.reverse(list);
        return list;
    }
}