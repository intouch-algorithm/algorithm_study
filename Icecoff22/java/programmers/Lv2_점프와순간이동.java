import java.util.*;

public class Lv2_점프와순간이동 {
    public int solution(int n) {
        int ans = 0;
        while(n!=0) {
            if(n%2==0) {
                n /= 2;
            } else {
                ans++;
                n--;
            }
        }
        return ans;
    }
}
// 효율성 메모리/시간초과
// 해법 : 바텀업 x 탑다운 o
// array에만 집착x
// feat. 주원