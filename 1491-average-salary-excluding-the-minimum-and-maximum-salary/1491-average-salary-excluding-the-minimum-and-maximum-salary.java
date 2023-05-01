class Solution {
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        double sum = 0;
        
        for(int i=0;i<salary.length;++i){
            sum += salary[i];
            min = Math.min(min,salary[i]);
            max = Math.max(max,salary[i]);
        }
        
        double ans = (sum - (min+max)) / (salary.length-2);
        
        return ans;
    }
}