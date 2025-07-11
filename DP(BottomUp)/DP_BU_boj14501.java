import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DP_BU_boj14501 {
    static class interview {
        int t;
        int p;

        public interview(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    static int n;
    static List<interview> array = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            array.add(new interview(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            dp[i] = 0;
        }

        for(int i=n-1; i>=0; i--){
            if (i + array.get(i).t > n){
                dp[i] = dp[i + 1];
            }
            else {
                dp[i] = Math.max(dp[i + array.get(i).t] + array.get(i).p, dp[i + 1]);
            }
        }

        System.out.println(dp[0]);
        br.close();
    }
}
