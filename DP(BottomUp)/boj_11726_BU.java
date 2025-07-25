import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11726_BU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1];

        dp[1] = 1;
        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }

        dp[2] = 2;
        if (n == 2) {
            System.out.println(dp[2]);
            return;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println((long)dp[n] % 10007);
        br.close();
    }
}