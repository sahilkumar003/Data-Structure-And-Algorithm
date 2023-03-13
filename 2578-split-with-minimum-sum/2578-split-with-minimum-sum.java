class Solution {
    public int splitNum(int num) {
        ArrayList<Integer> list = new ArrayList<>();
        while(num>0){
            list.add(num%10);
            num = num/10;
        }
        
        Collections.sort(list);
        String n1 = "";
        String n2 = "";
        
        for(int i=0;i<list.size();++i){
            if(i%2==0){
                n1 += list.get(i);
            }else{
            n2 += list.get(i);
            }
        }
        return Integer.parseInt(n1)+Integer.parseInt(n2);
    }
}