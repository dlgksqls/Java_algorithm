package 복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DP_TD_boj12865 {

    static class bag {
        int w, v;

        public bag(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    static int n, k;
    static List<bag> array = new ArrayList<>();
    static int[][] dp;

    private static int recursion(int idx, int weight) {

        if (idx == n){
            return 0;
        }
        if (weight > k) {
            return Integer.MIN_VALUE;
        }
        if (dp[idx][weight] != -1) {
            return dp[idx][weight];
        }

        // 물건을 넣는 경우
        if (weight + array.get(idx).w <= k){
            dp[idx][weight] = Math.max(recursion(idx+1, weight+array.get(idx).w) + array.get(idx).v,
                    recursion(idx+1, weight));
        }
        else{
            dp[idx][weight] = recursion(idx + 1, weight);
        }
        return dp[idx][weight];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][k + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            array.add(new bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        // dp 배열 초기화
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(recursion(0, 0));
        br.close();
    }
}
