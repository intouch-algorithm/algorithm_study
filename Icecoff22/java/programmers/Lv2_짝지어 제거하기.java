import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        String[] strArr = s.split("");
        Stack<String> stack = new Stack<>();
        
        for(int i=0;i<strArr.length;i++) {
            if (!stack.isEmpty()) {
                System.out.println(stack.peek()+" "+strArr[i]);
                if (stack.peek()==strArr[i]) {
                    System.out.println("hihi");
                    stack.pop();
                    continue;
                }
            }
            stack.push(strArr[i]);
            
        }
        if (stack.isEmpty()){
            return 1;
        }
        else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.solution("baabaa");

	}

}