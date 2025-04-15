import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DP_BU_boj12865 {

    static int n, k;
    static int[][] dp;
    static int[] w, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        w = new int[n + 1];
        v = new int[n + 1];
        dp = new int[n + 1][k + 1]; // [물건 수][무게 제한]

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        // Bottom-Up 방식 DP 채우기
        for (int i = 1; i <= n; i++) { // i: 현재 물건
            for (int j = 0; j <= k; j++) { // j: 현재 무게
                if (w[i] > j) {
                    dp[i][j] = dp[i - 1][j]; // 현재 물건을 못 담는다
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }

        System.out.println(dp[n][k]);
        br.close();
    }
}
