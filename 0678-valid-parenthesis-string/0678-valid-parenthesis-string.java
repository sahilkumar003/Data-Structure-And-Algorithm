class Solution {
    public boolean checkValidString(String s) {
       Stack<Integer> stack = new Stack<>();
       Stack<Integer> temp = new Stack<>();
       
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            
            if(c=='('){
                stack.push(i);
            }else if(c == '*'){
                temp.push(i);
            }else if(!stack.isEmpty()){
                stack.pop();
            }else if(!temp.isEmpty()){
                temp.pop();
            }else{
                return false;
            }
        }
        
        while(!temp.isEmpty() && !stack.isEmpty() && stack.peek()<temp.peek()){
            stack.pop();
            temp.pop();
        }
        
        return stack.isEmpty();
    }
}