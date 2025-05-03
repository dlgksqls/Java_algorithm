package D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 유니온 파인드 사용하라는데,, 나중에 다시 보자
public class swea_1251_다시 {
    static class Island{
        long x;
        long y;

        public Island(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static boolean[] visited;
    static Island[] islands;
    static double e;
    static double answer;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc ++){
            n = Integer.parseInt(br.readLine());
            islands = new Island[n];
            visited = new boolean[n];
            long[] array_x = new long[n];
            long[] array_y = new long[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array_x[i] = Long.parseLong(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                array_y[i] = Long.parseLong(st.nextToken());
            }

            for (int i = 0; i < n; i++) {
                islands[i] = new Island(array_x[i], array_y[i]);
            }

            e = Double.parseDouble(br.readLine());
            answer = Integer.MAX_VALUE;

            visited[0] = true;
            recursion(0, 0);

            System.out.println("#" + tc + " " + Math.round(answer * e));
        }

        br.close();
    }

    private static void recursion(int idx, double price) {
        if (idx == n - 1) {
            answer = Math.min(answer, price);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                double distance = Math.sqrt(Math.pow(islands[i].x - islands[idx].x, 2) + Math.pow(islands[i].y - islands[idx].y, 2));
                recursion(i, price + distance * distance);
                visited[i] = false;
            }
        }
    }
}
