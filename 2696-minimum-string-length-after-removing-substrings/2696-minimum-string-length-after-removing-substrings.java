class Solution {
    public int minLength(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while(true){
            boolean check = false;
            for(int i=0;i<sb.length();++i){
                char c = sb.charAt(i);
                if(i+1<sb.length() && c=='A' && sb.charAt(i+1)=='B'){
                    check = true;
                    sb.delete(i,i+2);
                    break;
                }else if(i+1<sb.length() && c=='C' && sb.charAt(i+1)=='D'){
                    check = true;
                    sb.delete(i,i+2);
                    break;
                }
            }
            
            if(!check){
                break;
            }
        }
        
        return sb.length();
    }
}