import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1495 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][s] = true;

        for(int i = 0; i < n; i++){
            for(int j = 0; j <= m; j++){
                if(dp[i][j]){
                    if(j + array[i] <= m) dp[i + 1][j + array[i]] = true;
                    if(j - array[i] >= 0) dp[i + 1][j - array[i]] = true;
                }
            }
        }

        for(int i = m; i >= 0; i--){
            if(dp[n][i]){
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
