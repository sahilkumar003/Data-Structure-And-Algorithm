class Solution {
    public boolean isHappy(int n) {
        int sum = 0;
        ArrayList<Integer> list = new ArrayList<>(); 
        
        while(n>0){
            int last = n%10;
            sum = sum + (last*last);
         
            n = n/10;
            if(n==0){
                 if(sum == 1){
                return true;
            }
                n = sum;
                
                if(list.contains(sum)){
                    return false;
                }else{
                    list.add(sum);
                }
                sum = 0;
            }
        }
        return false;
    }
}