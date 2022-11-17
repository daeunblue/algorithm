import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){ // 여는 괄호는 항상 스택에 push
                stack.push(s.charAt(i));
            }else{  // 닫는 괄호인 경우
                if(stack.isEmpty() || stack.peek() != '('){ // 비어있는 상태거나 여는 괄호가 맨 위에 있지 않는 경우
                    answer = false;
                    break;
                }else{
                    stack.pop();
                }
            }
        }    
        
        // 괄호가 아직 스택에 남아있다면
        if(!stack.isEmpty()) answer = false;

        return answer;
    }
}