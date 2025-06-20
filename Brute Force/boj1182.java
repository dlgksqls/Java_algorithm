import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1182 {
    static int n;
    static int k;
    static int[] array;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        recursion(0, 0);

        // k가 0일때 아무것도 선택하지 않는 경우의 수 빼주기
        if (k == 0) answer --;
        System.out.println(answer);
        br.close();
    }

    private static void recursion(int idx, int sum) {
        if (idx == n){
            if (sum == k) {
                answer ++;
            }
            return;
        }

        recursion(idx + 1, sum + array[idx]);

        recursion(idx + 1, sum);
    }
}
