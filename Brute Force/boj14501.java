import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj14501 {
    static int n;
    static ArrayList<Meeting> meetings = new ArrayList<>();
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        recursion(0, 0);

        System.out.println(answer);
        br.close();
    }

    private static void recursion(int idx, int value) {
        if (idx == n){
            answer = Math.max(answer, value);
            return;
        }

        if (idx + meetings.get(idx).time  <= n) {
            recursion(idx + meetings.get(idx).time, value + meetings.get(idx).value);
        }

        recursion(idx + 1, value);
    }

    private static class Meeting {
        int time;
        int value;

        public Meeting(int time, int value) {
            this.time = time;
            this.value = value;
        }
    }
}
