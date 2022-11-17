class Solution {
    public int maximumSwap(int n) {
        int temp = n;
        ArrayList<Integer> list = new ArrayList<>();
        while(temp>0){
            int x = temp%10;
            list.add(x);
            temp /= 10;
        }

        Collections.reverse(list);
        int index1 = 0;
        int index2 = 0;
        int max = 0;

        for(int i=0;i<list.size();++i){
             index1 = i;
             max  = list.get(i);   
            for(int j=i+1;j<list.size();++j){
                if(list.get(j)>=max){
                    max = list.get(j);
                    index2 = j;
                }
            }
            if(max>list.get(i)){
                break;
            }
        }
        
        Collections.swap(list,index1,index2);
        
        String s = "";

        for(int i=0;i< list.size();++i){
           s += list.get(i);
        }

        int ans = Integer.parseInt(s);

        return Math.max(n,ans);
    }
}