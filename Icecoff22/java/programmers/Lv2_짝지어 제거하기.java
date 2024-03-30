// import java.util.*;
// class Solution
// {
//     public int solution(String s)
//     {
//         int answer = -1;
//         String[] strArr = s.split("");
//         Stack<String> stack = new Stack<>();
        
//         for(int i=0;i<strArr.length;i++) {
//             if (!stack.isEmpty()) {
//                 System.out.println(stack.peek()+" "+strArr[i]);
//                 if (stack.peek()==strArr[i]) {
//                     System.out.println("hihi");
//                     stack.pop();
//                     continue;
//                 }
//             }
//             stack.push(strArr[i]);
            
//         }
//         if (stack.isEmpty()){
//             return 1;
//         }
//         else {
//             return 0;
//         }
//     }

//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         sol.solution("baabaa");

// 	}

// }
// /* 패인포인트 */
// // 객체를 객체로 보지 않아 '=='사용
// // equals를 사용하여 해결
// // 이외의 풀이로 s.toCharArray()함수를 사용하여
// // char 배열로 바꾼 이후 for문을 돌리면
// // '==' 사용하여 해결 가능!