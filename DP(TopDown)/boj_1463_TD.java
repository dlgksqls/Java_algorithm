import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1463_TD {
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        for(int i=0; i<=n; i++){
            dp[i] = -1;
        }
        dp[1] = 0;

        System.out.println(recursion(n));
        br.close();
    }

    private static int recursion(int n) {
        if (dp[n] != -1) return dp[n];

        dp[n] = recursion(n-1) + 1;

        if (n % 3 == 0){
            dp[n] = Math.min(dp[n], recursion(n / 3) + 1);
        }
        if (n % 2 == 0){
            dp[n] = Math.min(dp[n], recursion(n / 2) + 1);
        }
        return dp[n];
    }
}
