class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(stack.isEmpty() || c=='(' || c=='{' || c=='['){       
                stack.push(c);
            }else{
                if(c==')'){
                    if(!stack.isEmpty() && stack.pop()!='('){
                        return false;
                    }
                }else if(c=='}'){
                    if(!stack.isEmpty() && stack.pop()!='{'){
                        return false;
                    }
                }else if(c==']'){
                    if(!stack.isEmpty() && stack.pop()!='['){
                        return false;
                    }
                }else{
                    break;
                }
            }
        }
        
        return stack.isEmpty();
    }
}