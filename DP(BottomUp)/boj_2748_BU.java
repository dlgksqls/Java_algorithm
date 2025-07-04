import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2748_BU {
    static long[] dp; // int → long, 피보나치 수가 커질 수 있어서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[n]);
        br.close();
    }
}