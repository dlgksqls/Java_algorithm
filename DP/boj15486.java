import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj15486 {
    static class Interview {
        int t;
        int p;

        public Interview(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }

    static int n;
    static int[] dp;
    static ArrayList<Interview> interviews = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            interviews.add(new Interview(t, p));
            dp[i] = 0;
        }

        for(int i=n-1; i>=0; i--){
            if (i + interviews.get(i).t > n){
                dp[i] = dp[i+1];
            }
            else {
                dp[i] = Math.max(dp[i + interviews.get(i).t] + interviews.get(i).p, dp[i+1]);
            }
        }

        System.out.println(dp[0]);

        dp = new int[n+1];
        System.out.println(recursion(0));

        br.close();
    }

    private static int recursion(int idx) {
        if (idx >= n) return 0;
        if (dp[idx] != 0) return dp[idx];

        if (idx + interviews.get(idx).t > n){
            dp[idx] = recursion(idx + 1);
        }
        else{
            dp[idx] = Math.max(recursion(idx + interviews.get(idx).t) + interviews.get(idx).p, recursion(idx + 1));
        }

        return dp[idx];
    }
}
