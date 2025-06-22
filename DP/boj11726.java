import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11726 {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 1) {
            System.out.println(1);
            return;
        }
        if (n == 2){
            System.out.println(2);
            return;
        }

        initializeDp(n);
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        System.out.println(dp[n]);

        initializeDp(n);
        System.out.println(recursion(n));
        br.close();
    }

    private static void initializeDp(int n) {
        dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++){
            dp[i] = -1;
        }
    }

    private static int recursion(int n) {
        if (dp[n] != -1) return dp[n];
        dp[n] = (recursion(n-1) + recursion(n - 2)) % 10007;
        return dp[n];
    }
}
