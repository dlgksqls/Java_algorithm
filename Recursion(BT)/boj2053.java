import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class boj2053 {

    static class NumberBaseball{
        int number;
        int strike;
        int ball;

        public NumberBaseball(int number, int strike, int ball) {
            this.number = number;
            this.strike = strike;
            this.ball = ball;
        }
    }

    static int n;
    static int answer = 0;
    static NumberBaseball[] array;

    private static boolean check(int hintIdx, int number) {
        String number_str = Integer.toString(number);

        int strike_count = 0;
        int ball_count = 0;

        String hint_str = String.valueOf(array[hintIdx].number);
        int strike = array[hintIdx].strike;
        int ball = array[hintIdx].ball;

        for (int i = 0; i < 3; i++) {
            if (number_str.charAt(i) == hint_str.charAt(i)) strike_count++;
            else if (hint_str.indexOf(number_str.charAt(i)) != -1) ball_count++;
        }

        if (strike == strike_count && ball == ball_count) return true;
        return false;
    }

    public static void recursion(int hint_idx, int number){

        if (hint_idx == n){
            answer ++;
            recursion(0, number+1);
            return;
        }

        if (number == 1000) return;

        if (check(hint_idx, number)) {
            recursion(hint_idx + 1, number);
        }
        else {
            recursion(0, number + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new NumberBaseball[n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());
            array[i] = new NumberBaseball(number, strike, ball);
        }

        recursion(0, 100);
        System.out.println(answer);

        br.close();
    }
}
