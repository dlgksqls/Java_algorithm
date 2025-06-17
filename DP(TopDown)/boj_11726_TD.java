import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11726_TD {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

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

        System.out.println(recursion(n));
        br.close();
    }

    private static int recursion(int i) {
        if (dp[i] != 0) return dp[i];
        dp[i] = (recursion(i - 1) + recursion(i - 2)) % 10007;
        return dp[i];
    }
}