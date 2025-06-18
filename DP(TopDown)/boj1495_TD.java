import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1495_TD {
    static boolean[][] dp;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new boolean[n+1][m+1];

        st = new StringTokenizer(br.readLine());
        list = new int[n+1];
        for(int i=1; i<=n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, s, n, m);

        int result = -1;
        for(int vol = m; vol >= 0; vol --){
            if (dp[n][vol]) {
                result = vol;
                break;
            }
        }

        System.out.println(result);
        br.close();
    }

    private static void recursion(int i, int s, int n, int m) {
        if (s > m || s < 0) return;

        if (dp[i][s]) return;

        dp[i][s] = true;

        if (i == n) return;
        recursion(i + 1, s + list[i+1], n, m);
        recursion(i + 1, s - list[i+1], n, m);
    }
}
