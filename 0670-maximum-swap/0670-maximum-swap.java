class Solution {
    public int maximumSwap(int n) {
        if(n<=10){
            return n;
        }
        
         char[] c = Integer.toString(n).toCharArray();
        int []arr = new int[c.length];

        int index = 0;
        int max = 0;
        for(int i=c.length-1;i>=0;--i){
            if(Character.getNumericValue(c[i])>max){
                max = Character.getNumericValue(c[i]);
                arr[i] = i;
                index = i;
            }else{
                arr[i] = index;
            }
        }

        for(int i=0;i<c.length;++i){
            if(Character.getNumericValue(c[i])<Character.getNumericValue(c[arr[i]])){
                char temp = c[i];
                c[i] = c[arr[i]];
                c[arr[i]] = temp;
                break;
            }
        }

        String s = "";

        for(int i=0;i<c.length;++i){
            s += c[i];
        }

        int ans = Integer.parseInt(s);
        
        return Math.max(ans,n);
    }
}