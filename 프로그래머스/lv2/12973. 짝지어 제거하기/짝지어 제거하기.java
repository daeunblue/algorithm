import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        ArrayList<Character> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        boolean flag = false;
        
        if(s.length() == 0) return 1;   // 빈 문자열
        
        for(int i=0; i<s.length(); i++){
            if(stack.empty()){
                stack.push(s.charAt(i));
                continue;
            } 
            char start = stack.peek();
            char temp = s.charAt(i);
            
            if(start == temp){
                stack.pop();
            } 
            else{
                stack.push(s.charAt(i));
            }
        }
            
        if(!stack.empty()) answer = 0;
        else answer = 1;
        
        return answer;
    }
    
}