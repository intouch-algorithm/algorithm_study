class Solution {
    public int solution(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        for(int i=2;i<=n;i++) {
            arr[i] = (arr[i-1] + arr[i-2])%1234567;
        }
        return arr[n];
    }
}
/*
# 패인 포인트
# java의 큰수를 다루지 못함.
# 해결방법
# for문을 돌면 계속 나머지를 구함.
*/