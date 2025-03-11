package Lv1;

public class x_만큼_간격있는_n개의_숫자 {

    public static long[] solution(int x, int n) {
        long[] answer = {};
        answer = new long[n];

        for (int i=0; i<n; i++){
            answer[i] = (long) x * (i+1);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(-4, 2));
    }
}
