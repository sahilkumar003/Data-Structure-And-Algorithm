class Solution {
    public int[] separateDigits(int[] nums) {
        
        
        List<Integer>lst=new ArrayList<>();
        
        
        for(int elements:nums){
            
            String temp=""+elements;
            
            for(int i=0;i<temp.length();++i){
                
                lst.add(temp.charAt(i)-'0');
            }
        }
        
        int size[]=new int[lst.size()];
        
        for(int i=0;i<lst.size();++i){
            
            size[i]=lst.get(i);
        }
        
        return size;
    }
}