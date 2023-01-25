class Solution {
    public String getPermutation(int n, int k) {
        if(n==1){
            return "1";
        }
        
        ArrayList<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i=1;i<n;++i){
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        k--;
        StringBuffer ans = new StringBuffer();

        while(true){
            ans.append(numbers.get(k/fact));
            numbers.remove(k/fact);
            if(numbers.size()==1){
                ans.append(numbers.get(0));
                break;
            }
            k %= fact;
            fact /= numbers.size();
        }

        return ans.toString();
    }
}