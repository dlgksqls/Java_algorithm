import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1495 {
    static boolean[][] dp;
    static int[] array;
    static int n, s, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        initilizedp();
        dp[0][s] = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j <= m; j++){
                if(dp[i][j]){
                    if(j + array[i] <= m) dp[i + 1][j + array[i]] = true;
                    if(j - array[i] >= 0) dp[i + 1][j - array[i]] = true;
                }
            }
        }

        printResult();

        initilizedp();
        recursion(0, s);
        printResult();

        br.close();
    }

    private static void printResult() {
        int result = -1;
        for(int i = m; i >= 0; i--){
            if(dp[n][i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    private static void recursion(int i, int vol) {
        if (vol > m || vol < 0) return;   // 현재 볼륨 검사
        if (dp[i][vol]) return;           // 이미 방문한 상태면 중복 방지

        dp[i][vol] = true;                // 방문 표시

        if (i == n) return;               // 곡 끝까지 도달

        recursion(i + 1, vol + array[i]); // 다음 곡: 볼륨 증가
        recursion(i + 1, vol - array[i]); // 다음 곡: 볼륨 감소
    }

    private static void initilizedp() {
        dp = new boolean[n + 1][m + 1];
    }
}
