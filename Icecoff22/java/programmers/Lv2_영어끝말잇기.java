class Lv2_ {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        String[] tmp = new String[words.length];
        tmp[0] = words[0];
        for (int i=1;i<words.length;i++) {
            System.out.println(words[i-1].charAt(words[i-1].length()-1)+ ", " + words[i].charAt(0));
            if (words[i-1].charAt(words[i-1].length()-1)!=words[i].charAt(0)) {
                answer[0] = i/n+1;
                answer[1] = i/n+1;
                return answer;
            }
            for (int j=0;j<tmp.length;j++) {
                if (words[i].equals(tmp[j])) {
                    answer[0] = i/n+1;
                    answer[1] = i/n+1;
                    return answer;
                }
            }
            tmp[i] = words[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        Lv2_ sol = new Lv2_();
        String[] arr = {"hello", "one", "even", "never", "now", "world", "draw"};
        int[] res = sol.solution(2, arr);
        System.out.println(res[0]+","+res[1]);

	}

}